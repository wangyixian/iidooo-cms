/**
 * Created by Ethan on 16/5/31.
 */

var Actions = Reflux.createActions(['search']);

var Store = Reflux.createStore({
    listenables: [Actions],
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
            React.createElement("div", null, 
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
        return (
            React.createElement("a", {href: "#", className: "list-group-item"}, 
                React.createElement("h4", {className: "list-group-item-heading"}, this.props.content.contentTitle), 
                React.createElement("p", {className: "list-group-item-text"}, this.props.content.contentSummary), 
                React.createElement("div", {className: "text-right"}, 
                    React.createElement("span", {className: "margin-right-10"}, new Date(this.props.content.createTime).format('yyyy-MM-dd hh:mm:ss')), 
                    React.createElement("span", {className: "margin-right-10"}, "阅读(", this.props.content.pageViewCount, ")"), 
                    React.createElement("span", {className: "margin-right-10"}, ContentStatusMap[this.props.content.status])
                )
            )
        );
    }
});

var MyContentListPage = React.createClass({displayName: "MyContentListPage",
    mixins: [Reflux.connect(Store, 'contentListData')],
    getInitialState: function () {
        return {
            contentListData: {
                page: {},
                contentList: []
            }
        };
    },
    componentWillMount: function () {
        Actions.search(this.state);
    },
    onChildChanged: function (childState) {
        if (childState.currentPage != null) {
            var data = {};
            data.currentPage = childState.currentPage;
            Actions.search(data);
        }
    },
    render: function () {
        return (
            React.createElement("div", null, 
                React.createElement(Header, {activeMenuID: "menuMyContentList"}), 

                React.createElement("div", {className: "container"}, 
                    React.createElement("div", {className: "row"}, 
                        React.createElement("div", {className: "col-sm-3"}, 
                            React.createElement(UserInfo, {user: securityUser})
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
            React.createElement("div", null, 
                React.createElement("div", {className: "panel panel-default"}, 
                    React.createElement("div", {className: "panel-heading"}, 
                        React.createElement("h3", {className: "panel-title"}, "个人资料")
                    ), 
                    React.createElement("div", {className: "panel-body"}, 
                        React.createElement("ul", {className: "list-group"}, 
                            React.createElement("li", {className: "list-group-item"}, 
                                React.createElement("img", {src: this.props.user.photoURL, className: "img-square-200"})
                            ), 
                            React.createElement("li", {className: "list-group-item"}, "姓名：", this.props.user.userName), 
                            React.createElement("li", {className: "list-group-item"}, "邮箱：", this.props.user.email), 
                            React.createElement("li", {className: "list-group-item"}, "经验：", this.props.user.experience), 
                            React.createElement("li", {className: "list-group-item"}, "等级：", this.props.user.level), 
                            React.createElement("li", {className: "list-group-item"}, "积分：", this.props.user.points)
                        )
                    )
                )
            )
        );
    }
});

ReactDOM.render(
    React.createElement(MyContentListPage, null),
    document.getElementById('page')
);