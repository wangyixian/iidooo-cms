/**
 * Created by Ethan on 16/4/27.
 */

$(function () {
    initSelChannelList("channelID");

    initSelContentType("contentType");

    initSelContentStatus("status");

    $('.form_date').datetimepicker({
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0,
        format: 'yyyy-mm-dd'
    });

    $('.form_time').datetimepicker({
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 1,
        minView: 0,
        maxView: 1,
        forceParse: 0,
        format: 'hh:ii:ss'
    });

    // 说明是修改
    if (pageMode == 2) {
        initForModifyMode();
    }

    changeContentType();
});

function initForModifyMode() {
    var url = serverURL + getContentURL;
    var data = {};
    data.appID = appID;
    data.secret = secret;
    data.accessToken = accessToken;
    data.userID = userID;
    data.contentID = CmsContent.contentID;

    var callback = function (data) {

        $("#contentID").val(data.contentID);
        $("#channelID").val(data.channelID);
        $("#contentType").val(data.contentType);
        $("#contentTitle").val(data.contentTitle);
        $("#contentSubTitle").val(data.contentSubTitle);
        $("#contentImageTitle").val(data.contentImageTitle);
        if (data.isSilent == "1") {
            $("#isSilent").attr("checked", true);
        } else {
            $("#isSilent").attr("checked", false);
        }
        $("#stickyIndex").val(data.stickyIndex);
        $("#metaTitle").val(data.metaTitle);
        $("#metaKeywords").val(data.metaKeywords);
        $("#metaDescription").val(data.metaDescription);
        $("#contentSummary").val(data.contentSummary);
        $("#contentBody").val(data.contentBody);
        $("#startShowDate").val(data.startShowDate);
        $("#startShowTime").val(data.startShowTime);
        $("#endShowDate").val(data.endShowDate);
        $("#endShowTime").val(data.endShowTime);
        $("#status").val(data.status);
        $("#source").val(data.source);
        $("#sourceURL").val(data.sourceURL);
        console.log(data);

        if (data.pictureList.length > 0) {
            $("#divContentImageList").attr("class", "show");
            $.each(data.pictureList, function (index, object) {
                console.log(object)
                // 加入上传路径
                var $divInputPic = $("#divInputContentPic");
                var $pictureList = $("<input type='text' class='form-control'/>");
                $pictureList.val(object.pictureURL);
                $pictureList.attr("id", "pictureList" + object.pictureID);
                $divInputPic.append($pictureList);

                // 删除按钮
                var $divContentPicDelete = $("#divContentPicDelete");
                var $deleteButton = $("<button type='button' class='btn btn-default' aria-label='Remove'>" +
                    "<span class='glyphicon glyphicon-remove' aria-hidden='true'></span>" +
                    "</button>");
                $divContentPicDelete.append($deleteButton);

                $deleteButton.bind("click", function () {
                    $("#pictureList" + object.pictureID).remove();
                    $(this).remove();

                    if ($("#divInputContentPic > input").length <= 0) {
                        $("#divContentImageList").attr("class", "hidden");
                    }
                });
            });
        }

        console.log(data);
    };
    ajaxPost(url, data, callback);
}

function changeContentType() {
    var contentType = $("#contentType").val();
    switch (contentType) {
        case "1":
            $("#newsFields").removeClass("show");
            $("#newsFields").addClass("hidden");
            break;
        case "2":
            $("#newsFields").removeClass("hidden");
            $("#newsFields").addClass("show");
            break;
    }
}

// 上传标题图
$("#uploadImageTitle").fileupload({
    url: serverURL + uploadFileURL,
    dataType: 'json',
    autoUpload: true,
    acceptFileTypes: /(\.|\/)(jpe?g|png|gif)$/i,
    maxNumberOfFiles: 1,
    formData: {'appID': appID, 'secret': secret, 'accessToken': accessToken, 'fileType': '1'},
    maxFileSize: 10000000,
    done: function (e, result) {
        var data = result.result;
        if (data.status == "200") {
            $("#contentImageTitle").val(data.data.url);
            var $imgImageTitle = $("#imgImageTitle");
            $imgImageTitle.attr("src", data.data.url);
            $imgImageTitle.css("width", '200px');
            $imgImageTitle.css("height", '200px');
        } else {
            alert("请求接收但处理失败，请联系管理员！");
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

// 上传内容主体图
$("#uploadContentBodyImage").fileupload({
    url: serverURL + uploadFileURL,
    dataType: 'json',
    autoUpload: true,
    acceptFileTypes: /(\.|\/)(jpe?g|png|gif)$/i,
    maxNumberOfFiles: 1,
    formData: {
        'appID': appID,
        'secret': secret,
        'accessToken': accessToken,
        'fileType': $("#selContentBodyFileType").val()
    },
    maxFileSize: 10000000,
    done: function (e, result) {
        var data = result.result;
        if (data.status == "200") {
            var contentBodyVal = $("#contentBody").val();
            $("#contentBody").val(contentBodyVal + "![](" + data.data.url + ")");

            var converter = new showdown.Converter();
            var rawMarkup = converter.makeHtml($("#contentBody").val());
            $("#txtContentBodyPreview").html(rawMarkup);

        } else {
            alert("服务器端处理失败，出现异常，请联系管理员！");
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


// 上传内容图片列表
$("#uploadContentImage").fileupload({
    url: serverURL + uploadFileURL,
    dataType: 'json',
    autoUpload: true,
    acceptFileTypes: /(\.|\/)(jpe?g|png|gif)$/i,
    maxNumberOfFiles: 1,
    formData: {'appID': appID, 'secret': secret, 'accessToken': accessToken, 'fileType': $("#selFileType").val()},
    maxFileSize: 10000000,
    done: function (e, result) {
        var data = result.result;
        if (data.status == "200") {
            $("#divContentImageList").attr("class", "show");

            // 加入上传路径
            var $divInputPic = $("#divInputContentPic");
            var $pictureList = $("<input type='text' class='form-control'/>");
            $pictureList.val(data.data.url);
            var index = $("#divInputContentPic > input").length + 1;
            $pictureList.attr("id", "pictureList" + index);
            $divInputPic.append($pictureList);

            // 删除按钮
            var $divContentPicDelete = $("#divContentPicDelete");
            var $deleteButton = $("<button type='button' class='btn btn-default' aria-label='Remove'>" +
                "<span class='glyphicon glyphicon-remove' aria-hidden='true'></span>" +
                "</button>");
            $divContentPicDelete.append($deleteButton);

            $deleteButton.bind("click", function () {
                $("#pictureList" + index).remove();
                $(this).remove();

                if ($("#divInputContentPic > input").length <= 0) {
                    $("#divContentImageList").attr("class", "hidden");
                }
            });
        } else {
            alert("服务器端处理失败，出现异常，请联系管理员！");
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

$('#contentSummary').keyup(function () {
    showdown.setOption('strikethrough', 'true');
    var converter = new showdown.Converter();
    var rawMarkup = converter.makeHtml($("#contentSummary").val());
    $("#txtSummaryPreview").html(rawMarkup);
});

$('#contentBody').keyup(function () {
    showdown.setOption('strikethrough', 'true');
    var converter = new showdown.Converter();
    var rawMarkup = converter.makeHtml($("#contentBody").val());
    $("#txtContentBodyPreview").html(rawMarkup);
});

$("#btnSave").bind("click", function () {
    var url = serverURL + createContentURL;
    var data = {};
    data.appID = appID;
    data.secret = secret;
    data.accessToken = accessToken;
    data.userID = userID;

    // 如果是更新的话，需要加上
    if (pageMode == 2) {
        url = serverURL + updateContentURL;
        data.contentID = $("#contentID").val()
    }

    data.channelID = $("#channelID").val();
    data.contentType = $("#contentType").val();
    data.contentTitle = $("#contentTitle").val();
    data.contentSubTitle = $("#contentSubTitle").val();
    data.contentImageTitle = $("#contentImageTitle").val();
    if ($("#isSilent").is(':checked')) {
        data.isSilent = "1";
    } else {
        data.isSilent = "0";
    }
    data.stickyIndex = $("#stickyIndex").val();
    data.metaTitle = $("#metaTitle").val();
    data.metaKeywords = $("#metaKeywords").val();
    data.metaDescription = $("#metaDescription").val();
    data.contentSummary = $("#contentSummary").val();
    data.contentBody = $("#contentBody").val();
    data.startShowDate = $("#startShowDate").val();
    data.startShowTime = $("#startShowTime").val();
    data.endShowDate = $("#endShowDate").val();
    data.endShowTime = $("#endShowTime").val();
    data.status = $("#status").val();
    data.source = $("#source").val();
    data.sourceURL = $("#sourceURL").val();

    var $pictureList = $("input[id^=pictureList]");
    var pictureList = [];
    $.each($pictureList, function (index, object) {
        pictureList[index] = object.value;
    });

    data.pictureList = JSON.stringify(pictureList);

    console.log(data);
    var callback = function (data) {
        alert("保存成功！");
    };
    ajaxPost(url, data, callback);
});