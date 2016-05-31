/**
 * Created by Ethan on 16/5/13.
 */

var HeaderActions = Reflux.createActions(['getUserByToken', 'logout']);

var HeaderStore = Reflux.createStore({
    listenables: [HeaderActions],
    onGetUserByToken: function (data) {
        var url = URL.server + API.getUserByToken;
        data.appID = SecurityClient.appID;
        data.secret = SecurityClient.secret;
        data.accessToken = sessionStorage.getItem(SessionKey.accessToken);

        // 检查token是否过期
        if (data.accessToken == null || data.accessToken == "") {
            location.href = Page.login;
            return false;
        }

        var self = this;
        var callback = function (result) {
            if (result.status == 200) {
                securityUser = result.data;
                $.each(result.data.roleList, function (index, role) {
                    result.data.roleName = role.roleName;
                    result.data.roleCode = role.roleCode;
                    return false;
                });
                self.trigger(result.data);
            } else {
                console.log(result);
                location.href = Page.login;
            }
        };

        ajaxPost(url, data, callback);
    },

    onLogout: function (data) {
        sessionStorage.removeItem(SessionKey.accessToken);
        sessionStorage.removeItem(SessionKey.userID);
        location.href = Page.login;
    }
});

var Header = React.createClass({displayName: "Header",
    mixins: [Reflux.connect(HeaderStore, 'user')],
    getInitialState: function () {
        return {
            user: {
                roleName: ""
            }
        };
    },
    componentWillMount: function () {
        HeaderActions.getUserByToken(this.state);
    },
    onStatusChange: function (user) {
        this.state.user = user;
    },
    render: function () {
        return (
            React.createElement("header", {className: "header"}, 
                React.createElement("nav", {className: "navbar navbar-inverse"}, 
                    React.createElement("div", {className: "container-fluid"}, 
                        React.createElement("div", {className: "navbar-header"}, 
                            React.createElement(LOGO, null)
                        ), 
                        React.createElement("div", {id: "navbar", className: "navbar-collapse collapse"}, 
                            React.createElement(MainMenu, {activeMenuID: this.props.activeMenuID}), 
                            React.createElement(LoginInfo, {roleName: this.state.user.roleName, userName: this.state.user.userName})
                        )
                    )
                )
            )
        );
    }
});

var LOGO = React.createClass({displayName: "LOGO",
    render: function () {
        return (
            React.createElement("div", null, 
                React.createElement("a", {className: "navbar-brand", href: Page.myContentList}, "TOXIC WAVE CMS SYSTEM")
            )
        );
    }
});

var MainMenu = React.createClass({displayName: "MainMenu",
    componentDidUpdate: function () {
        var activeMenuID = this.props.activeMenuID;
        $("#" + activeMenuID).addClass("active");
    },
    render: function () {
        var editorShipMenu;
        if(securityUser.roleCode == role.admin || securityUser.roleCode == role.editorship){
            editorShipMenu = React.createElement(EditorShipMenu, null);
        }
        return (
            React.createElement("ul", {id: "mainMenu", className: "nav navbar-nav"}, 
                React.createElement("li", {id: "menuMyContentList"}, 
                    React.createElement("a", {href: Page.myContentList}, "我的毒电波")
                ), 
                React.createElement("li", {id: "menuCreateNews"}, 
                    React.createElement("a", {href: Page.createNews}, "发布毒电波")
                ), 
                editorShipMenu
            )
        );
    }
});

var EditorShipMenu = React.createClass({displayName: "EditorShipMenu",
    render: function () {
        return (
            React.createElement("li", {id: "menuContentManage"}, 
                React.createElement("a", {href: Page.contentList}, "内容管理")
            )
        );
    }
});

var LoginInfo = React.createClass({displayName: "LoginInfo",
    handleClick: function () {
        HeaderActions.logout();
    },

    render: function () {
        return (
            React.createElement("ul", {className: "nav navbar-nav navbar-right"}, 
                React.createElement("li", null, React.createElement("a", {href: "#"}, "您好，", this.props.roleName, " ", this.props.userName)), 
                React.createElement("li", null, React.createElement("a", {href: "#", onClick: this.handleClick}, "注销"))
            )
        );
    }
});