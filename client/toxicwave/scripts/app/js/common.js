/**
 * Created by Ethan on 16/4/6.
 */
URL = {
    client: "http://localhost:63342/toxicwave",
    server: "http://localhost:8080/iidooo-cms",

    // 正式环境
    //client: "http://www.iidooo.com/toxicwave",
    //server: "http://www.iidooo.com/iidooo-cms"
};

SessionKey = {
    accessToken: "ACCESS_TOKEN",
    userID: "USER_ID",
    user: "SECURITY_USER"
};

SecurityClient = {
    appID: "CMSSystem",
    secret: "e96b669ba65848bcb20f5de53dcc370e"
};

Message = {
    INPUT_REQUIRED: "红色区域为必填项！",
    EMAIL_REQUIRED: "请输入正确的Email地址!",
    VERIFY_CODE_REQUIRED: "请输入正确的验证码",
    LOGIN_FAILED: "身份验证失败！",
    LOGIN_FAILED_NO_USER: "该邮件所绑定的用户不存在",
    NO_PERMISSION: "你所在的用户组无权限执行该操作！",
    NO_PERMISSION_BY_READONLY_USER: "只读角色用户，无法进行编辑操作！",
    NO_PERMISSION_BY_CREATE_USER: "非此内容创建者，无法进行编辑操作！",
    NO_PERMISSION_BY_CONTENT_STATUS: "审核权限不够，无法进行编辑操作！"
};

ContentStatus = {
    PUBLISHED: "0",
    APPROVED: "2",
    REFUSE: "3"
};

ContentStatusMap = {
    "0": "已发布",
    "1": "未审核",
    "2": "审核通过",
    "3": "审核驳回",
    "4": "审核驳回修正"
};

API = {
    sendVerifyCode: "/core/sendVerifyCode",
    getAccessTokenByMail: "/core/getAccessTokenByMail",
    getUserByToken: "/core/getUserByToken",
    getChannelList: "/admin/getChannelList",
    getDictItemList: "/core/getDictItemList",
    searchContentList: "/admin/searchContentList",
    uploadFile: "/admin/uploadFile",
    createContent: "/admin/createContent",
    deleteContent: "/admin/deleteContent",
    getContent: "/admin/getContent",
    updateContent: "/admin/updateContent",
    content: "/content"
};

role = {
    admin: "admin",
    editorship: "editorship",
    editor: "editor",
    readonly: "readonly"
};

Page = {
    login: URL.client + "/pages/login.html",
    myContentList: URL.client + "/pages/myContentList.html",
    contentNews: URL.client + "/pages/createNews.html",
    contentList : URL.client +  "/pages/contentList.html",
    contentDetail : URL.client +  "/pages/contentDetail.html"
};

// 保存所获得的SecurityUser Model对象
securityUser = {};

var CmsPicture = {
    contentID: 0,
    createTime: 0,
    createUserID: 0,
    isDelete: 0,
    pictureID: 0,
    pictureName: "",
    pictureURL: "",
    remarks: "",
    sequence: 0,
    updateTime: 0,
    updateUserID: 0,
    version: 0,
}

// 日期格式化
Date.prototype.format = function (format) {
    var o = {
        "M+": this.getMonth() + 1, //month
        "d+": this.getDate(),   //day
        "h+": this.getHours(),  //hour
        "m+": this.getMinutes(), //minute
        "s+": this.getSeconds(), //second
        "q+": Math.floor((this.getMonth() + 3) / 3), //quarter
        "S": this.getMilliseconds() //millisecond
    }
    if (/(y+)/.test(format)) format = format.replace(RegExp.$1,
        (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)if (new RegExp("(" + k + ")").test(format))
        format = format.replace(RegExp.$1,
            RegExp.$1.length == 1 ? o[k] :
                ("00" + o[k]).substr(("" + o[k]).length));
    return format;
}

// 得到地址栏中的路径指定参数值
function getQueryStr(key) {
    var url = window.document.location.href;
    if (url.indexOf("?") != -1) {
        var queryStr = url.substr(url.indexOf("?") + 1);
        var params = queryStr.split("&");
        for (var i = 0; i < params.length; i++) {
            var param = params[i].split("=");
            if (param != null && param.length == 2 && param[0] == key) {
                return param[1];
            }
        }
    }
    return "";
}


function ajaxPost(url, data, callback) {
    $.ajax({
        type: "POST",
        timeout: 3000, //超时时间设置，单位毫秒
        url: url,
        dataType: "json",
        data: data,
        success: function (result) {
            if (result && null != result.status && ((result.status + "").indexOf("20") == 0)) {
                callback(result);
            } else {
                alert("服务器端处理失败，出现异常，详细请看控制台！错误编号：" + result.status);
                console.log(result);
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            //ajaxpost(url, data, callback);
        }
    });
}

function ajaxFileUpload(id, url, data, callback){
    $("#" + id).fileupload({
        url: url,
        dataType: 'json',
        autoUpload: true,
        acceptFileTypes: /(\.|\/)(jpe?g|png|gif)$/i,
        maxNumberOfFiles: 1,
        formData: data,
        maxFileSize: 10000000,
        done: function (e, result) {
            console.log(result);
            var data = result.result;
            if (result && null != result.status && ((result.status + "").indexOf("20") == 0)) {
                callback(result);
            } else {
                alert("服务器端处理失败，出现异常，详细请看控制台！错误编号：" + result.status);
                console.log(data);
            }
        },
        progressall: function (e, data) {
            var progress = parseInt(data.loaded / data.total * 100, 10) + "%";

            console.log(progress);
        },
        error: function (e, data) {

            console.log('Error!');
        },
        fail: function (e, data) {

            console.log('Fail!');
        }
    });
}

function openFileBrowse(fileID){
    var ie=navigator.appName=="Microsoft Internet Explorer" ? true : false;
    if(ie){
        document.getElementById(fileID).click();
        document.getElementById("filename").value=document.getElementById("file").value;
    }else{
        var a=document.createEvent("MouseEvents");//FF的处理
        a.initEvent("click", true, true);
        document.getElementById(fileID).dispatchEvent(a);
    }
}

// 提供showdown格式的预览
function showdownPreview(content, containerID) {
    showdown.setOption('strikethrough', 'true');
    var converter = new showdown.Converter();
    var rawMarkup = converter.makeHtml(content);
    $("#" + containerID).html(rawMarkup);
}

function dataPermission(messageBoxID, content) {
    var isRefuse = false;
    var text = "";
    // 权限控制
    if (securityUser.roleCode == role.readonly) {
        isRefuse = true;
        text = Message.NO_PERMISSION_BY_READONLY_USER;
    } else if (securityUser.roleCode == role.editor) {
        if (content.createUserID != securityUser.userID) {
            isRefuse = true;
            text = Message.NO_PERMISSION_BY_CREATE_USER;
        } else if (content.status == ContentStatus.PUBLISHED ||
            content.status == ContentStatus.APPROVED) {
            isRefuse = true;
            text = Message.NO_PERMISSION_BY_CONTENT_STATUS;
        }
    }

    if (isRefuse && messageBoxID != null) {
        var $messageBox = $("#" + messageBoxID);
        $messageBox.text(text);
        $messageBox.removeClass("hidden");
        $messageBox.addClass("show");
        $("input,select,textarea").attr('readonly', true);
        $("input[type='checkbox']").attr('disabled', true);
        $("input[type='file']").attr('disabled', true);
    }

    return isRefuse;
}

function validateEmail(email) {
    var regex = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
    if (!regex.test(email)) {
        return false;
    }

    return true;
}