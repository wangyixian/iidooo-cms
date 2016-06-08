/**
 * Created by Ethan on 16/5/31.
 */

var PageActions = Reflux.createActions(['search']);

var PageStore = Reflux.createStore({
    listenables: [PageActions],
    onSearch: function (data) {

        var url = URL.server + API.searchContentList;
        data.appID = SecurityClient.appID;
        data.secret = SecurityClient.secret;
        data.accessToken = sessionStorage.getItem(SessionKey.accessToken);
        data.userID = sessionStorage.getItem(SessionKey.userID);

        // 检查token是否过期
        if (data.accessToken == null || data.accessToken == "" || data.userID == null || data.userID == "") {
            location.href = Page.login;
            return false;
        }

        data.sortField = "CreateTime";
        data.channelID = 1;
        data.pageSize = 10;
        data.contentType = "2";

        var self = this;

        var callback = function (result) {
            if (result.status == 200) {
                self.trigger(result.data);
            } else {
                console.log(result);
            }
        };

        ajaxPost(url, data, callback);
    },
});

var ContentList = React.createClass({displayName: "ContentList",
    render: function () {
        return (
            React.createElement("div", {className: "contentList"}, 
                React.createElement("div", {className: "list-group"}, 
                    this.props.contentListData.contentList.map(function (item) {
                        return React.createElement(ContentSummary, {key: item.contentID, content: item})
                    })
                )
            )
        );
    }
});

var ContentSummary = React.createClass({displayName: "ContentSummary",
    render: function () {
        var editLink;
        if (this.props.content.status != ContentStatus.APPROVED && this.props.content.status != ContentStatus.PUBLISHED) {
            editLink = React.createElement(EditLink, {contentID: this.props.content.contentID});
        } else {
            editLink = React.createElement(ReadLink, {contentID: this.props.content.contentID});
        }

        // 显示副标题或者摘要
        var subTitle = this.props.content.contentSubTitle;
        if (subTitle == "") {
            subTitle = this.props.content.contentSummary;
        }

        return (
            React.createElement("div", {className: "list-group-item"}, 
                React.createElement("h4", {className: "list-group-item-heading"}, this.props.content.contentTitle), 

                React.createElement("div", {className: "list-group-item-text"}, subTitle), 

                React.createElement("div", {className: "text-right"}, 
                    React.createElement("span", {className: "margin-right-10"}, "阅读(", this.props.content.pageViewCount, ")"), 
                    React.createElement("span", {
                        className: "margin-right-10"}, new Date(this.props.content.createTime).format('yyyy-MM-dd hh:mm:ss')), 
                    React.createElement("span", {className: "margin-right-10"}, ContentStatusMap[this.props.content.status]), 
                    editLink
                )
            )
        );
    }
});

var EditLink = React.createClass({displayName: "EditLink",

    handleClick: function () {
        sessionStorage.setItem(SessionKey.pageMode, 2);
        sessionStorage.setItem(SessionKey.contentID, this.props.contentID);
        location.href = Page.contentNews;
    },

    render: function () {
        return (
            React.createElement("a", {href: "javascript:void(0)", onClick: this.handleClick}, 
            React.createElement("span", {className: "margin-right-10"}, "编辑"
            ))
        );
    }
});

var ReadLink = React.createClass({displayName: "ReadLink",
    render: function () {
        return (
            React.createElement("span", {className: "margin-right-10"}, 
            React.createElement("a", {href: URL.server + API.content + "/"+this.props.contentID, target: "_blank"}, "预览")
            )
        );
    }
});

var MyContentList = React.createClass({displayName: "MyContentList",
    mixins: [Reflux.connect(PageStore, 'contentListData')],
    getInitialState: function () {
        return {
            contentListData: {
                page: {},
                contentList: []
            }
        };
    },
    componentWillMount: function () {
        PageActions.search(this.state);
    },
    onChildChanged: function (childState) {
        if (childState.currentPage != null) {
            var data = {};
            data.currentPage = childState.currentPage;
            PageActions.search(data);
        }
    },
    render: function () {
        var user = JSON.parse(sessionStorage.getItem(SessionKey.user));
        return (
            React.createElement("div", null, 
                React.createElement(Header, {activeMenuID: "menuMyContentList"}), 

                React.createElement("div", {className: "container"}, 
                    React.createElement("div", {className: "row"}, 
                        React.createElement("div", {className: "col-sm-3 user-info-wrap"}, 
                            React.createElement(UserInfo, {user: user})
                        ), 
                        React.createElement("div", {className: "col-sm-9"}, 
                            React.createElement(ContentList, {contentListData: this.state.contentListData}), 
                            React.createElement(Pager, {callbackParent: this.onChildChanged, 
                                   recordSum: this.state.contentListData.page.recordSum, 
                                   currentPage: this.state.contentListData.page.currentPage, 
                                   pageSum: this.state.contentListData.page.pageSum})
                        )
                    )
                ), 

                React.createElement(Footer, null)
            )
        );
    }
});

var UserInfo = React.createClass({displayName: "UserInfo",
    render: function () {
        return (
            React.createElement("div", {className: "panel panel-default"}, 
                React.createElement("div", {className: "panel-heading"}, 
                    React.createElement("h3", {className: "panel-title"}, "个人资料")
                ), 
                React.createElement("div", {className: "panel-body"}, 
                    React.createElement("ul", {className: "list-group"}, 
                        React.createElement("li", {className: "list-group-item"}, 
                            React.createElement("img", {src: this.props.user.photoURL, className: "img-square-200"})
                        ), 
                        React.createElement("li", {className: "list-group-item"}, React.createElement("span", {className: "inline-block"}, "昵称："), React.createElement("span", {className: "break-word"}, this.props.user.userName)), 
                        React.createElement("li", {className: "list-group-item"}, React.createElement("span", {className: "inline-block"}, "邮箱："), React.createElement("span", {className: "break-word"}, this.props.user.email)), 
                        React.createElement("li", {className: "list-group-item"}, React.createElement("span", {className: "inline-block"}, "等级："), React.createElement("span", {className: "break-word"}, this.props.user.level))
                    )
                )
            )
        );
    }
});

ReactDOM.render(
    React.createElement(MyContentList, null),
    document.getElementById('page')
);