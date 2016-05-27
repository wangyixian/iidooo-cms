/**
 * Created by Ethan on 16/5/13.
 */

var Actions = Reflux.createActions(['sendVerifyCode', 'login']);

var Store = Reflux.createStore({

    listenables: [Actions],

    onSendVerifyCode: function (data) {
        var url = URL.server + API.sendVerifyCode;
        data.appID = SecurityClient.appID;
        data.secret = SecurityClient.secret;

        var callback = function (result) {
            console.log(result);
        };

        ajaxPost(url, data, callback);
    },

    onLogin: function (data) {
        var url = URL.server + API.getAccessTokenByMail;
        data.appID = SecurityClient.appID;
        data.secret = SecurityClient.secret;

        var callback = function (result) {
            if (result.status == 200) {
                sessionStorage.setItem(SessionKey.accessToken, result.data.token);
                sessionStorage.setItem(SessionKey.userID, result.data.userID);
                location.href = Page.contentList;
            } else {
                var message = Message.LOGIN_FAILED;
                if(result.status == 201){
                    message = Message.LOGIN_FAILED_NO_USER
                }
                $("#messageBox").text(message);
                console.log(result);
            }
        };

        ajaxPost(url, data, callback);
    }
});

var LoginForm = React.createClass({displayName: "LoginForm",
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
            React.createElement("div", null, 
                React.createElement("div", {className: "form-top"}, 
                    React.createElement("div", {className: "form-top-left"}, 
                        React.createElement("h3", null, "毒电波发布平台登录"), 

                        React.createElement("p", null, "请输入邮箱及验证码：", React.createElement("span", {id: "messageBox", className: "label label-danger"}))
                    ), 
                    React.createElement("div", {className: "form-top-right"}, 
                        React.createElement("img", {src: "../img/login/qrcode.jpg", alt: "扫我下载毒电波APP"})
                    )
                ), 
                React.createElement("div", {className: "form-bottom"}, 
                    React.createElement("div", {className: "form-group"}, 
                        React.createElement("label", {className: "sr-only", htmlFor: "form-email"}, "邮箱"), 
                        React.createElement("input", {ref: "inputEmail", type: "text", id: "inputEmail", placeholder: "请输入Email地址", 
                               className: "form-email form-control"})
                    ), 
                    React.createElement("div", {className: "form-group"}, 
                        React.createElement("label", {className: "sr-only", htmlFor: "form-verify"}, "验证码"), 
                        React.createElement("input", {id: "inputVerify", ref: "inputVerify", type: "text", name: "form-verify", placeholder: "请输入验证码", 
                               className: "form-verify"}), 
                        React.createElement("button", {id: "btnSendVerify", type: "button", className: "btn btn-verify", 
                                onClick: this.handleSendVerify}, this.state.sendButtonText)
                    ), 
                    React.createElement("button", {type: "button", className: "btn btn-block", onClick: this.handleLogin}, "登录")
                )
            )
        );
    }
});

ReactDOM.render(
    React.createElement(LoginForm, null),
    document.getElementById('loginForm')
);

