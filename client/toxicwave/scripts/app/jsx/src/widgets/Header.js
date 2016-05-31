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

var Header = React.createClass({
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
            <header className="header">
                <nav className="navbar navbar-inverse">
                    <div className="container-fluid">
                        <div className="navbar-header">
                            <LOGO/>
                        </div>
                        <div id="navbar" className="navbar-collapse collapse">
                            <MainMenu activeMenuID={this.props.activeMenuID}/>
                            <LoginInfo roleName={this.state.user.roleName} userName={this.state.user.userName}/>
                        </div>
                    </div>
                </nav>
            </header>
        );
    }
});

var LOGO = React.createClass({
    render: function () {
        return (
            <div>
                <a className="navbar-brand" href={Page.myContentList}>TOXIC WAVE CMS SYSTEM</a>
            </div>
        );
    }
});

var MainMenu = React.createClass({
    componentDidUpdate: function () {
        var activeMenuID = this.props.activeMenuID;
        $("#" + activeMenuID).addClass("active");
    },
    render: function () {
        var editorShipMenu;
        if(securityUser.roleCode == role.admin || securityUser.roleCode == role.editorship){
            editorShipMenu = <EditorShipMenu/>;
        }
        return (
            <ul id="mainMenu" className="nav navbar-nav">
                <li id="menuMyContentList">
                    <a href={Page.myContentList}>我的毒电波</a>
                </li>
                <li id="menuCreateNews">
                    <a href={Page.createNews}>发布毒电波</a>
                </li>
                {editorShipMenu}
            </ul>
        );
    }
});

var EditorShipMenu = React.createClass({
    render: function () {
        return (
            <li id='menuContentManage'>
                <a href={Page.contentList}>内容管理</a>
            </li>
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
                <li><a href="#">您好，{this.props.roleName} {this.props.userName}</a></li>
                <li><a href="#" onClick={this.handleClick}>注销</a></li>
            </ul>
        );
    }
});