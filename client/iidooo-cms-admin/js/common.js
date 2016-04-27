/**
 * Created by Ethan on 16/4/6.
 */
//var client = "http://localhost:63342/iidooo-cms-admin-admin";
//var server = "http://localhost:8080/iidooo-cms-admin";
var client = "http://www.iidooo.com/iidooo-cms-admin";
var server = "http://www.iidooo.com/iidooo-cms";

var appID = "CMSSystem";
var secret = "e96b669ba65848bcb20f5de53dcc370e";
var accessToken = function () {
    $.cookie("ACCESS_TOKEN");
};

var getContentTypeList = "/admin/getContentTypeList";

var searchContentList = "/admin/searchContentList";

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