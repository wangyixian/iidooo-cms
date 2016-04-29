/**
 * Created by Ethan on 16/4/22.
 */

var channelMap = {}; // Key: channelID Value: channelName
var contentTypeMap = {}; // Key: dictItemCode Value: dictItemName
var contentStatusMap = {}; // Key: dictItemCode Value: dictItemName

$(function () {
    //console.log("content-manage init");
    initSelChannelList("selChannelList");
    initSelContentType("selContentType");
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
});

function initSelChannelList(id) {
    $.ajax({
        type: 'POST',
        url: serverURL + "/admin/getChannelList",
        data: {
            appID: appID,
            secret: secret,
            accessToken: accessToken
        },
        dataType: 'json',
        success: function (result) {
            var temp = eval(result);
            if (result.status == 200) {
                //console.info(result);
                var $selChannelList = $("#" + id);
                for (var i = 0; i < result.data.length; i++) {
                    var channel = result.data[i];

                    // 记录到channelMap
                    channelMap[channel.channelID] = channel.channelName;

                    var $option = $("<option></option>");
                    $option.attr("value", channel.channelID);
                    $option.text(channel.channelName);
                    $selChannelList.append($option);
                }
            }
        }
    });
}

function initSelContentType(id) {
    $.ajax({
        type: 'POST',
        url: serverURL + getDictItemListURL,
        data: {
            appID: appID,
            secret: secret,
            accessToken: accessToken,
            dictClassCode: "DICT_CLASS_CONTENT_TYPE"
        },
        dataType: 'json',
        success: function (result) {
            if (result.status == 200) {
                //console.info(result);
                var $selContentType = $("#" + id);
                for (var i = 0; i < result.data.length; i++) {
                    var dictItem = result.data[i];

                    // 记录到contentTypeMap
                    contentTypeMap[dictItem.dictItemCode] = dictItem.dictItemName;

                    var $option = $("<option></option>");
                    $option.attr("value", dictItem.dictItemCode);
                    $option.text(dictItem.dictItemName);
                    $selContentType.append($option);
                }
            }
        }
    });
}

function initSelContentStatus(id) {
    $.ajax({
        type: 'POST',
        url: serverURL + getDictItemListURL,
        data: {
            appID: appID,
            secret: secret,
            accessToken: accessToken,
            dictClassCode: "DICT_CLASS_CONTENT_STATUS"
        },
        dataType: 'json',
        success: function (result) {
            if (result.status == 200) {
                //console.info(result);
                var $selContentStatus = $("#" + id);
                for (var i = 0; i < result.data.length; i++) {
                    var dictItem = result.data[i];

                    // 记录到contentTypeMap
                    contentStatusMap[dictItem.dictItemCode] = dictItem.dictItemName;

                    var $option = $("<option></option>");
                    $option.attr("value", dictItem.dictItemCode);
                    $option.text(dictItem.dictItemName);
                    $selContentStatus.append($option);
                }
            }
        }
    });
}

function search() {
    var channelID = $("#selChannelList").val();
    var contentTitle = $("#inputContentTitle").val();
    var contentType = $("#selContentType").val();
    var startDate = $("#inputStartDate").val();
    var endDate = $("#inputEndDate").val();
    var status = $("#status").val();

    $.ajax({
        type: 'POST',
        url: serverURL + searchContentListURL,
        data: {
            appID: appID,
            secret: secret,
            accessToken: accessToken,
            channelID: channelID,
            contentTitle: contentTitle,
            contentType: contentType,
            startDate: startDate,
            endDate: endDate,
            status: status
        },
        dataType: 'json',
        success: function (result) {
            if (result.status == 200) {
                var $tableSearcResult = $("#tableSearcResult tbody");

                // 先清空表格数据
                $tableSearcResult.empty();

                // 插入新的查询所获得的数据
                for (var i = 0; i < result.data.length; i++) {
                    var content = result.data[i];
                    var $tr = $("<tr></tr>");
                    var $tdContentID = $("<td>" + content.contentID + "</td>");
                    var $tdChannelID = $("<td>" + channelMap[content.channelID] + "</td>");
                    var $tdContentTitle = $("<td>" + content.contentTitle + "</td>");
                    var $tdStickyIndex = $("<td>" + content.stickyIndex + "</td>");
                    var $tdContentType = $("<td>" + contentTypeMap[content.contentType] + "</td>");
                    var $tdStatus = $("<td>" + contentStatusMap[content.status] + "</td>");
                    var $tdCreateUserID = $("<td>" + content.createUser.userName + "</td>");
                    var $tdCreateTime = $("<td>" + new Date(content.createTime).format('yyyy-MM-dd hh:mm:ss') + "</td>");
                    var $tdPageViewCount = $("<td>" + content.pageViewCount + "</td>");
                    var $tdOption = $("<td><a id='btnModify' href='#'>修改</a> | <a id='btnDelete' href='#'>删除</a> | <a id='btnSticky' href='#'>置顶</a></td>");

                    $tr.append($tdContentID);
                    $tr.append($tdChannelID);
                    $tr.append($tdContentTitle);
                    $tr.append($tdStickyIndex);
                    $tr.append($tdContentType);
                    $tr.append($tdStatus);
                    $tr.append($tdCreateUserID);
                    $tr.append($tdCreateTime);
                    $tr.append($tdPageViewCount);
                    $tr.append($tdOption);

                    $tableSearcResult.append($tr);

                    $("#btnModify").attr("id", "btnModify" + i);
                    $("#btnDelete").attr("id", "btnDelete" + i);
                    $("#btnSticky").attr("id", "btnSticky" + i);

                    $("#btnModify" + i).attr("onclick", "modifyContent(" + content.contentID + ")");
                    $("#btnDelete" + i).attr("onclick", "deleteContent(" + content.contentID + ")");
                    $("#btnSticky" + i).attr("onclick", "stickyContent(" + content.contentID + ")");
                }
            }
        }
    });
}

$("#btnCreate").bind("click", function () {
    pageMode = 1;
    loadPage("/content-detail.html", "content-manage");
});

function modifyContent(contentID) {
    pageMode = 2;
    CmsContent.contentID = contentID;
    //alert(contentID);
    loadPage("/content-detail.html", "content-manage");
}

function deleteContent() {
}

function stickyContent() {
}