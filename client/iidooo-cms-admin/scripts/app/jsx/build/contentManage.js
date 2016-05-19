/**
 * Created by Ethan on 16/5/18.
 */

var ContentManageActions = Reflux.createActions(['search']);

var ContentManageStore = Reflux.createStore({
    listenables: [ContentManageActions],
    onSearch: function (data) {
        var url = serverURL + searchContentListURL;
        data.appID = appID;
        data.secret = secret;
        data.accessToken = $.cookie("ACCESS_TOKEN");
        // 检查token是否过期
        if (data.accessToken == null || data.accessToken == "") {
            alert("登陆过期，请重新登陆！");
            location.href = clientURL + loginPage;
            return false;
        }

        var self = this;
        var channelMap = data.channelMap;
        var contentTypeMap = data.contentTypeMap;
        var contentStatusMap = data.contentStatusMap;
        var callback = function (result) {
            if (result.status == 200) {
                // 从后台取到的都是ID，此处设置一些显示值
                for (var i = 0; i < result.data.length; i++) {
                    var content = result.data[i];
                    content.channelName = channelMap[content.channelID];
                    content.contentTypeName = contentTypeMap[content.contentType];
                    content.statusName = contentStatusMap[content.status];
                }
                self.trigger(result.data);
            } else {
                console.log(result);
                alert("获取登陆用户信息失败！");
            }
        };

        ajaxPost(url, data, callback);
    }
});

var ContentManage = React.createClass({displayName: "ContentManage",
    mixins: [Reflux.connect(ContentManageStore, 'contentList')],
    getInitialState: function () {
        return {
            channelID: 0,
            contentTitle: "",
            contentType: 0,
            startDate: "",
            endDate: "",
            status: 0,
            contentList: [],
            channelMap: {},
            contentTypeMap: {},
            contentStatusMap: {}
        };
    },
    onStatusChange: function (contentList) {
        this.state.contentList = contentList;
    },
    handleSearch: function () {
        this.state.contentTitle = this.refs.inputContentTitle.value;
        this.state.startDate = this.refs.inputStartDate.value;
        this.state.endDate = this.refs.inputEndDate.value;
        ContentManageActions.search(this.state);
    },
    onChildChanged: function (childState) {
        if (childState.channelID != null) {
            this.state.channelID = childState.channelID;
        }
        if (childState.contentType != null) {
            this.state.contentType = childState.contentType;
        }
        if (childState.contentStatus != null) {
            this.state.status = childState.contentStatus;
        }
        if (childState.channelMap != null) {
            this.state.channelMap = childState.channelMap;
        }
        if (childState.contentTypeMap != null) {
            this.state.contentTypeMap = childState.contentTypeMap;
        }
        if (childState.contentStatusMap != null) {
            this.state.contentStatusMap = childState.contentStatusMap;
        }
    },
    render: function () {
        return (
            React.createElement("div", null, 
                React.createElement("div", {className: "search-condition-section"}, 
                    React.createElement("div", {className: "form-horizontal"}, 
                        React.createElement("div", {className: "row form-group"}, 
                            React.createElement("div", {className: "col-xs-4"}, 
                                React.createElement("div", {className: "col-xs-4 control-label"}, 
                                    React.createElement("label", {htmlFor: "channelList"}, "所属栏目")
                                ), 
                                React.createElement("div", {className: "col-xs-8"}, 
                                    React.createElement(ChannelList, {ref: "channelList", channelID: this.state.channelID, callbackParent: this.onChildChanged})
                                )
                            ), 
                            React.createElement("div", {className: "col-xs-4"}, 
                                React.createElement("div", {className: "col-xs-4 control-label"}, 
                                    React.createElement("label", null, "内容标题")
                                ), 
                                React.createElement("div", {className: "col-xs-8"}, 
                                    React.createElement("input", {type: "text", className: "form-control", ref: "inputContentTitle"})
                                )
                            ), 
                            React.createElement("div", {className: "col-xs-4"}, 
                                React.createElement("div", {className: "col-xs-4 control-label"}, 
                                    React.createElement("label", null, "内容类型")
                                ), 
                                React.createElement("div", {className: "col-xs-8"}, 
                                    React.createElement(ContentTypeList, {contentType: this.state.contentType, callbackParent: this.onChildChanged})
                                )
                            )
                        )
                    ), 

                    React.createElement("div", {className: "form-horizontal"}, 
                        React.createElement("div", {className: "row form-group"}, 
                            React.createElement("div", {className: "col-xs-4"}, 
                                React.createElement("div", {className: "col-xs-4 control-label"}, 
                                    React.createElement("label", null, "发布开始日")
                                ), 
                                React.createElement("div", {className: "col-xs-8"}, 
                                    React.createElement("div", {className: "input-group date form_date", "data-date": "", 
                                         "data-date-format": "yyyy-mm-dd", 
                                         "data-link-field": "startDate", "data-link-format": "yyyy-mm-dd"}, 
                                        React.createElement("input", {id: "startDate", className: "form-control", type: "text", ref: "inputStartDate", 
                                               readonly: true}), 
                                        React.createElement("span", {className: "input-group-addon"}, 
                                            React.createElement("span", {className: "glyphicon glyphicon-calendar"})
                                        )
                                    )
                                )
                            ), 
                            React.createElement("div", {className: "col-xs-4"}, 
                                React.createElement("div", {className: "col-xs-4 control-label"}, 
                                    React.createElement("label", null, "发布结束日")
                                ), 
                                React.createElement("div", {className: "col-xs-8"}, 
                                    React.createElement("div", {className: "input-group date form_date", "data-date": "", 
                                         "data-date-format": "yyyy-mm-dd", 
                                         "data-link-field": "endDate", "data-link-format": "yyyy-mm-dd"}, 
                                        React.createElement("input", {id: "endDate", className: "form-control", type: "text", ref: "inputEndDate", 
                                               readonly: true}), 
                                        React.createElement("span", {className: "input-group-addon"}, 
                                            React.createElement("span", {className: "glyphicon glyphicon-calendar"})
                                        )
                                    )
                                )
                            ), 
                            React.createElement("div", {className: "col-xs-4"}, 
                                React.createElement("div", {className: "col-xs-4 control-label"}, 
                                    React.createElement("label", null, "内容状态")
                                ), 
                                React.createElement("div", {className: "col-xs-8"}, 
                                    React.createElement(ContentStatusList, {contentStatus: this.state.status, 
                                                       callbackParent: this.onChildChanged})
                                )
                            )
                        )
                    ), 

                    React.createElement("div", {className: "text-right"}, 
                        React.createElement("button", {id: "btnSearch", className: "btn btn-primary", type: "button", onClick: this.handleSearch}, 
                            "查 询"
                        ), 
                        " ", 
                        React.createElement("button", {id: "btnCreate", className: "btn btn-success", type: "button"}, "发 布")
                    )
                ), 
                React.createElement("div", {className: "search-result-section"}, 
                    React.createElement("table", {className: "table table-striped table-hover"}, 
                        React.createElement("thead", null, 
                        React.createElement("tr", null, 
                            React.createElement("th", null, "ID"), 
                            React.createElement("th", null, "栏目"), 
                            React.createElement("th", null, "标题"), 
                            React.createElement("th", null, "置顶级别"), 
                            React.createElement("th", null, "类型"), 
                            React.createElement("th", null, "状态"), 
                            React.createElement("th", null, "发布者"), 
                            React.createElement("th", null, "发布时间"), 
                            React.createElement("th", null, "PV"), 
                            React.createElement("th", null, "快捷操作")
                        )
                        ), 
                        React.createElement("tbody", null, 
                        this.state.contentList.map(function (item) {
                            return React.createElement(ContentList, {key: item.contentID, content: item})
                        })
                        )
                    ), 
                    React.createElement("nav", {className: "text-center"}, 
                        React.createElement("ul", {className: "pagination"}, 
                            React.createElement("li", null, 
                                React.createElement("a", {href: "#", "aria-label": "Previous"}, 
                                    React.createElement("span", {"aria-hidden": "true"}, "«")
                                )
                            ), 
                            React.createElement("li", {className: "active"}, React.createElement("a", {href: "#"}, "1")), 
                            React.createElement("li", null, React.createElement("a", {href: "#"}, "2")), 
                            React.createElement("li", null, React.createElement("a", {href: "#"}, "3")), 
                            React.createElement("li", null, React.createElement("a", {href: "#"}, "4")), 
                            React.createElement("li", null, React.createElement("a", {href: "#"}, "5")), 
                            React.createElement("li", null, 
                                React.createElement("a", {href: "#", "aria-label": "Next"}, 
                                    React.createElement("span", {"aria-hidden": "true"}, "»")
                                )
                            )
                        )
                    )
                )
            )
        );
    }
});

var ContentList = React.createClass({displayName: "ContentList",
    render: function () {
        return (
            React.createElement("tr", null, 
                React.createElement("td", null, this.props.content.contentID), 
                React.createElement("td", null, this.props.content.channelName), 
                React.createElement("td", null, this.props.content.contentTitle), 
                React.createElement("td", null, this.props.content.stickyIndex), 
                React.createElement("td", null, this.props.content.contentTypeName), 
                React.createElement("td", null, this.props.content.statusName), 
                React.createElement("td", null, this.props.content.createUser.userName), 
                React.createElement("td", null, new Date(this.props.content.createTime).format('yyyy-MM-dd hh:mm:ss')), 
                React.createElement("td", null, this.props.content.pageViewCount), 
                React.createElement("td", null, 
                    React.createElement("a", {id: "btnModify", href: "#"}, "修改"), " |", 
                    React.createElement("a", {id: "btnDelete", href: "#"}, "删除"), " |", 
                    React.createElement("a", {id: "btnSticky", href: "#"}, "置顶")
                )
            )
        );
    }
});

ReactDOM.render(
    React.createElement(ContentManage, null),
    document.getElementById('contentManage')
);

$(function () {
    $('.form_date').datetimepicker({
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0,
        format: 'yyyy-mm-dd'
    });
});