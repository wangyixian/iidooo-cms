/**
 * Created by Ethan on 16/5/13.
 */

var HeaderActions = Reflux.createActions(['getUserByToken', 'logout']);

var HeaderStore = Reflux.createStore({
    listenables: [HeaderActions],
    onGetUserByToken: function (data) {
        var url = serverURL + api.getUserByToken;
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
                alert("获取登陆用户信息失败！");
            }
        };

        ajaxPost(url, data, callback);
    },

    onLogout: function (data) {
        $.cookie("ACCESS_TOKEN", null);
        location.href = clientURL + loginPage;
    }
});

var Header = React.createClass({displayName: "Header",
    mixins: [Reflux.connect(HeaderStore, 'user')],
    getInitialState: function () {
        return {user: {
            roleName: ""
        }};
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
                            React.createElement(MainMenu, null), 
                            React.createElement(LoginInfo, {roleName: this.state.user.roleName, userName: this.state.user.userName})
                        )
                    )
                )
            )
        );
    }
});

var LOGO = React.createClass({displayName: "LOGO",
    getInitialState: function () {
        return {
            indexURL: clientURL + contentListPage
        };
    },
    render: function () {
        return (
            React.createElement("div", null, 
                React.createElement("a", {className: "navbar-brand", href: this.state.indexURL}, "IDO CMS SYSTEM")
            )
        );
    }
});

var MainMenu = React.createClass({displayName: "MainMenu",
    getInitialState: function () {
        return {
            contentManageURL: clientURL + contentListPage
        };
    },
    render: function () {
        return (
            React.createElement("ul", {className: "nav navbar-nav"}, 
                React.createElement("li", {className: "active"}, 
                    React.createElement("a", {href: this.state.contentManageURL}, "内容管理")
                )
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


ReactDOM.render(
    React.createElement(Header, null),
    document.getElementById('header')
);