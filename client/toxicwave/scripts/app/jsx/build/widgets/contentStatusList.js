/**
 * Created by Ethan on 16/5/18.
 */

var ContentStatusListActions = Reflux.createActions(['getContentStatusList']);

var ContentStatusListStore = Reflux.createStore({
    listenables: [ContentStatusListActions],

    onGetContentStatusList: function (data) {
        var url = URL.server + API.getDictItemList;
        data.appID = SecurityClient.appID;
        data.secret = SecurityClient.secret;
        data.accessToken = sessionStorage.getItem(SessionKey.accessToken);
        data.dictClassCode = "DICT_CLASS_CONTENT_STATUS";

        // 检查token是否过期
        if (data.accessToken == null || data.accessToken == "") {
            location.href = Page.login;
            return false;
        }

        var self = this;
        var callback = function (result) {
            if (result.status == 200) {
                self.trigger(result.data);
            } else {
                console.log(result);
                alert("获取栏目列表信息失败！");
            }
        };

        ajaxPost(url, data, callback);
    }
});

var ContentStatusList = React.createClass({displayName: "ContentStatusList",
    mixins: [Reflux.connect(ContentStatusListStore, 'contentStatusList')],
    getInitialState: function () {
        return {
            contentStatus: this.props.contentStatus,
            contentStatusList: [],
            contentStatusMap: {}
        };
    },
    componentWillMount: function () {
        ContentStatusListActions.getContentStatusList(this.state);
    },
    componentDidUpdate: function () {
        for (var i = 0; i < this.state.contentStatusList.length; i++) {
            var dictItem = this.state.contentStatusList[i];
            this.state.contentStatusMap[dictItem.dictItemCode] = dictItem.dictItemName;
        }
        this.state.contentStatus = this.refs.inputContentStatus.value;
        this.props.callbackParent(this.state);
    },
    componentWillReceiveProps: function(nextProps) {
        this.refs.inputContentStatus.value = nextProps.contentStatus;
    },
    handleChange: function () {
        this.state.contentStatus = this.refs.inputContentStatus.value;
        // 这里要注意：setState 是一个异步方法，所以需要操作缓存的当前值
        this.props.callbackParent(this.state);
    },
    checkIsContainAll: function(){
        if(this.props.isContainAll == 'true') {
            return (
                React.createElement("option", {value: ""}, "全部")
            );
        }
    },
    render: function () {
        return (
            React.createElement("select", {className: "form-control", defaultValue: this.props.contentStatus, ref: "inputContentStatus", onChange: this.handleChange}, 
                this.checkIsContainAll(), 
                this.state.contentStatusList.map(function (item) {
                    return React.createElement("option", {key: item.dictItemCode, value: item.dictItemCode}, item.dictItemName)
                })
            )
        );
    }
});