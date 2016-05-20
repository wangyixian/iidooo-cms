/**
 * Created by Ethan on 16/4/6.
 */
 // 开发环境
var clientURL = "http://localhost:63342/iidooo-cms-admin";
var serverURL = "http://localhost:8080/iidooo-cms";

// 正式环境
//var clientURL = "http://www.iidooo.com/iidooo-cms-admin";
//var serverURL = "http://toxic.iidooo.com/iidooo-cms";

var appID = "CMSSystem";
var secret = "e96b669ba65848bcb20f5de53dcc370e";

// 页面操作的模式，0:无视 1:创建 2:修改
var pageMode = 0;

var getAccessTokenURL = "/admin/getAccessToken";
var getUserByTokenURL = "/admin/getUserByToken";
var getChannelListURL = "/admin/getChannelList";
var getDictItemListURL = "/core/getDictItemList";
var searchContentListURL = "/admin/searchContentList";
var uploadFileURL = "/admin/uploadFile";
var createContentURL = "/admin/createContent";
var getContentURL = "/admin/getContent";
var updateContentURL = "/admin/updateContent";

var loginPage = "/pages/login.html";
var contentListPage = "/pages/contentList.html";
var contentDetailPage = "/pages/contentDetail.html";

var CmsContent = {
    contentID: 0
};

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
            if(param != null && param.length == 2 && param[0] == key){
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

// 提供showdown格式的预览
function showdownPreview(content, containerID){
    showdown.setOption('strikethrough', 'true');
    var converter = new showdown.Converter();
    var rawMarkup = converter.makeHtml(content);
    $("#" + containerID).html(rawMarkup);
}