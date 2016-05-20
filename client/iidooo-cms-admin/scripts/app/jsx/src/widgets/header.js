/**
 * Created by Ethan on 16/5/13.
 */

var HeaderActions = Reflux.createActions(['getUserByToken', 'logout']);

var HeaderStore = Reflux.createStore({
    listenables: [HeaderActions],
    onGetUserByToken: function (data) {
        var url = serverURL + getUserByTokenURL;
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

var Header = React.createClass({
    mixins: [Reflux.connect(HeaderStore, 'user')],
    getInitialState: function () {
        return {user: {}};
    },
    componentWillMount: function () {
        HeaderActions.getUserByToken(this.state);
    },
    onStatusChange: function (user) {
        this.state.user = user;
    },
    render: function () {
        return (
            <header className="header">
                <nav className="navbar navbar-inverse">
                    <div className="container-fluid">
                        <div className="navbar-header">
                            <LOGO/>
                        </div>
                        <div id="navbar" className="navbar-collapse collapse">
                            <MainMenu/>
                            <LoginInfo userName={this.state.user.userName}/>
                        </div>
                    </div>
                </nav>
            </header>
        );
    }
});

var LOGO = React.createClass({
    getInitialState: function () {
        return {
            indexURL: clientURL + contentListPage
        };
    },
    render: function () {
        return (
            <div>
                <a className="navbar-brand" href={this.state.indexURL}>IDO CMS SYSTEM</a>
            </div>
        );
    }
});

var MainMenu = React.createClass({
    getInitialState: function () {
        return {
            contentManageURL: clientURL + contentListPage
        };
    },
    render: function () {
        return (
            <ul className="nav navbar-nav">
                <li className="active">
                    <a href={this.state.contentManageURL}>内容管理</a>
                </li>
            </ul>
        );
    }
});

var LoginInfo = React.createClass({
    handleClick: function () {
        HeaderActions.logout();
    },

    render: function () {
        return (
            <ul className="nav navbar-nav navbar-right">
                <li><a href="#">您好，{this.props.userName}</a></li>
                <li><a href="#" onClick={this.handleClick}>注销</a></li>
            </ul>
        );
    }
});


ReactDOM.render(
    <Header />,
    document.getElementById('header')
);