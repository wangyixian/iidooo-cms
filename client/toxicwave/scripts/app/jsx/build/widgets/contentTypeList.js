/**
 * Created by Ethan on 16/5/18.
 */

var ContentTypeListActions = Reflux.createActions(['getContentTypeList']);

var ContentTypeListStore = Reflux.createStore({
    listenables: [ContentTypeListActions],

    onGetContentTypeList: function (data) {
        var url = URL.server + API.getDictItemList;
        data.appID = SecurityClient.appID;
        data.secret = SecurityClient.secret;
        data.accessToken = sessionStorage.getItem(SessionKey.accessToken);
        data.dictClassCode = "DICT_CLASS_CONTENT_TYPE";

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

var ContentTypeList = React.createClass({displayName: "ContentTypeList",
    mixins: [Reflux.connect(ContentTypeListStore, 'contentTypeList')],
    getInitialState: function () {
        return {
            contentType: this.props.contentType,
            contentTypeList: [],
            contentTypeMap: {}
        };
    },
    componentWillMount: function () {
        ContentTypeListActions.getContentTypeList(this.state);
    },
    componentDidUpdate: function () {
        for (var i = 0; i < this.state.contentTypeList.length; i++) {
            var dictItem = this.state.contentTypeList[i];
            this.state.contentTypeMap[dictItem.dictItemCode] = dictItem.dictItemName;
        }
        this.state.contentType = this.refs.inputContentType.value;
        this.props.callbackParent(this.state);
    },
    componentWillReceiveProps: function(nextProps) {
        this.refs.inputContentType.value = nextProps.contentType;
    },
    handleChange: function () {
        this.state.contentType = this.refs.inputContentType.value;
        // 这里要注意：setState 是一个异步方法，所以需要操作缓存的当前值
        this.props.callbackParent(this.state);
    },
    checkIsContainAll: function(){
        if(this.props.isContainAll == 'true') {
            return (
                React.createElement("option", {value: "0"}, "全部")
            );
        }
    },
    render: function () {
        return (
            React.createElement("select", {className: "form-control", ref: "inputContentType", onChange: this.handleChange}, 
                this.checkIsContainAll(), 
                this.state.contentTypeList.map(function (item) {
                    return React.createElement("option", {key: item.dictItemCode, value: item.dictItemCode}, item.dictItemName)
                })
            )
        );
    }
});