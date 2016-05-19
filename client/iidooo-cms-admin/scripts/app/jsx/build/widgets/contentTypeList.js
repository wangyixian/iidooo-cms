/**
 * Created by Ethan on 16/5/18.
 */

var ContentTypeListActions = Reflux.createActions(['getContentTypeList']);

var ContentTypeListStore = Reflux.createStore({
    listenables: [ContentTypeListActions],

    onGetContentTypeList: function (data) {
        var url = serverURL + getDictItemListURL;
        data.appID = appID;
        data.secret = secret;
        data.accessToken = $.cookie("ACCESS_TOKEN");
        data.dictClassCode = "DICT_CLASS_CONTENT_TYPE";

        // 检查token是否过期
        if (data.accessToken == null || data.accessToken == "") {
            location.href = clientURL + loginPage;
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
        this.props.callbackParent(this.state);
    },
    handleChange: function () {
        this.state.contentType = this.refs.inputContentType.value;
        // 这里要注意：setState 是一个异步方法，所以需要操作缓存的当前值
        this.props.callbackParent(this.state);
    },
    render: function () {
        return (
            React.createElement("select", {className: "form-control", ref: "inputContentType", onChange: this.handleChange}, 
                React.createElement("option", {value: "0"}, "全部"), 
                this.state.contentTypeList.map(function (item) {
                    return React.createElement("option", {key: item.dictItemCode, value: item.dictItemCode}, item.dictItemName)
                })
            )
        );
    }
});