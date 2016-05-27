/**
 * Created by Ethan on 16/5/13.
 */

var Actions = Reflux.createActions(['sendVerifyCode', 'login']);

var Store = Reflux.createStore({

    listenables: [Actions],

    onSendVerifyCode: function (data) {
        var url = API.sendVerifyCode;
        data.appID = SecurityClient.appID;
        data.secret = SecurityClient.secret;

        var callback = function (result) {
            console.log(result);
        };

        ajaxPost(url, data, callback);
    },

    onLogin: function (data) {
        var url = API.getAccessTokenByMail;
        data.appID = SecurityClient.appID;
        data.secret = SecurityClient.secret;

        var callback = function (result) {
            if (result.status == 200) {
                sessionStorage.setItem(SessionKey.accessToken, result.data.token);
                sessionStorage.setItem(SessionKey.userID, result.data.userID);
                location.href = Page.contentList;
            } else {
                $("#messageBox").text(Message.LOGIN_FAILED);
                console.log(result);
            }
        };

        ajaxPost(url, data, callback);
    }
});

var LoginForm = React.createClass({
    getInitialState: function () {
        return {
            email: "",
            verifyCode: "",
            sendButtonText: "发送验证码"
        };
    },

    handleLogin: function () {
        this.state.email = this.refs.inputEmail.value;
        this.state.verifyCode = this.refs.inputVerify.value
        if (this.state.email == "" || !validateEmail(this.state.email) || this.state.verifyCode == "") {
            var $inputEmail = $("#inputEmail");
            var $inputVerify = $("#inputVerify");
            $inputEmail.attr("placeholder", Message.EMAIL_REQUIRED);
            $inputEmail.addClass("input-error");
            $inputVerify.attr("placeholder", Message.VERIFY_CODE_REQUIRED);
            $inputVerify.addClass("input-error");
            return false;
        }
        Actions.login(this.state);
    },

    handleSendVerify: function () {
        this.state.email = this.refs.inputEmail.value;
        if (this.state.email == "" || !validateEmail(this.state.email)) {
            $("#inputEmail").attr("placeholder", Message.EMAIL_REQUIRED);
            $("#inputEmail").addClass("input-error");
            return false;
        }
        Actions.sendVerifyCode(this.state);
        $("#btnSendVerify").attr("disabled", true);
        var minutes = 30;
        this.timer = setInterval(function () {
            if (minutes < 0) {
                $("#btnSendVerify").attr("disabled", false);
                this.state.sendButtonText = "重新发送";
                this.setState(this.state);
                return false;
            } else {
                this.state.sendButtonText = "重新发送" + minutes-- + "s";
                this.setState(this.state);
            }
        }.bind(this), 1000);
    },

    render: function () {
        return (
            <div>
                <div className="form-top">
                    <div className="form-top-left">
                        <h3>毒电波发布平台登录</h3>

                        <p>请输入邮箱及验证码：<span id="messageBox" className="label label-danger"></span></p>
                    </div>
                    <div className="form-top-right">
                        <img src="../img/login/qrcode.jpg" alt="扫我下载毒电波APP"/>
                    </div>
                </div>
                <div className="form-bottom">
                    <div className="form-group">
                        <label className="sr-only" htmlFor="form-email">邮箱</label>
                        <input ref="inputEmail" type="text" id="inputEmail" placeholder="请输入Email地址"
                               className="form-email form-control"/>
                    </div>
                    <div className="form-group">
                        <label className="sr-only" htmlFor="form-verify">验证码</label>
                        <input id="inputVerify" ref="inputVerify" type="text" name="form-verify" placeholder="请输入验证码"
                               className="form-verify"/>
                        <button id="btnSendVerify" type="button" className="btn btn-verify"
                                onClick={this.handleSendVerify}>{this.state.sendButtonText}</button>
                    </div>
                    <button type="button" className="btn btn-block" onClick={this.handleLogin}>登录</button>
                </div>
            </div>
        );
    }
});

ReactDOM.render(
    <LoginForm/>,
    document.getElementById('loginForm')
);

