/**
 * Created by Ethan on 16/4/6.
 */
 // 开发环境
var client = "http://localhost:63342/iidooo-cms-admin";
//var serverURL = "http://localhost:8080/iidooo-cms";

// 测试环境
var client = "http://www.iidooo.com/iidooo-cms-admin";
var serverURL = "http://www.iidooo.com/iidooo-cms";

// 正式环境
//var client = "http://toxic.iidooo.com:8080/iidooo-cms-admin";
//var serverURL = "http://toxic.iidooo.com:8080/iidooo-cms";

var appID = "CMSSystem";
var secret = "e96b669ba65848bcb20f5de53dcc370e";
var accessToken = "";
var userID = "";

// 页面操作的模式，0:无视 1:创建 2:修改
var pageMode = 0;

var getUserByTokenURL = "/admin/getUserByToken";

var getDictItemListURL = "/core/getDictItemList";

var searchContentListURL = "/admin/searchContentList";

var uploadFileURL = "/admin/uploadFile";

var createContentURL = "/admin/createContent";

var getContentURL = "/admin/getContent";

var updateContentURL = "/admin/updateContent";

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
                alert("服务器端处理失败，出现异常，详细请看控制台！错误编号：" + result.status);
                console.log(result);
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            //ajaxpost(url, data, callback);
        }
    });
}