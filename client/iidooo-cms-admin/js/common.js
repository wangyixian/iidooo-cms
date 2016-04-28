/**
 * Created by Ethan on 16/4/6.
 */
var client = "http://localhost:63342/iidooo-cms-admin";
var serverURL = "http://localhost:8080/iidooo-cms";
//var client = "http://www.iidooo.com/iidooo-cms-admin";
//var serverURL = "http://www.iidooo.com/iidooo-cms";

var appID = "CMSSystem";
var secret = "e96b669ba65848bcb20f5de53dcc370e";
var accessToken = "";
var userID = "";

var getUserByTokenURL = "/admin/getUserByToken";

var getContentTypeListURL = "/admin/getContentTypeList";

var searchContentListURL = "/admin/searchContentList";

var uploadFileURL = "/admin/uploadFile";

var createContentURL = "/admin/createContent";

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

function ajaxPost(url, data, callback) {
    $.ajax({
        type: "POST",
        timeout: 3000, //超时时间设置，单位毫秒
        url: url,
        dataType: "json",
        data: data,
        success: function (result) {
            if (result && null != result.status && ((result.status + "").indexOf("20") == 0)) {
                callback(result.data);
            } else {
                alert("请求接收但处理失败，请联系管理员！");
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            //ajaxpost(url, data, callback);
        }
    });
}