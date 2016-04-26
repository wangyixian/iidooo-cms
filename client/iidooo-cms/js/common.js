/**
 * Created by Ethan on 16/4/6.
 */
var client = "http://localhost:63342/iidooo-cms";
var server = "http://localhost:8080/iidooo-cms";
//var server = "http://www.iidooo.com";

var appID = "CMSSystem";
var secret = "e96b669ba65848bcb20f5de53dcc370e";
var accessToken = function(){
    $.cookie("ACCESS_TOKEN");
};

var getContentTypeList = "/admin/getContentTypeList";

var searchContentList = "/admin/searchContentList";
