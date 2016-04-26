/**
 * Created by Ethan on 16/4/22.
 */

$(function () {

    initSelChannelList();
    initSelContentType();
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

function initSelChannelList() {
    $.ajax({
        type: 'POST',
        url: server + "/admin/getChannelList",
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
                var $selChannelList = $("#selChannelList");
                for(var i=0; i < result.data.length; i++){
                    var channel = result.data[i];
                    var $option = $("<option></option>");
                    $option.attr("value", channel.channelID);
                    $option.text(channel.channelName);
                    $selChannelList.append($option);
                }
            }
        }
    });
}

function initSelContentType() {
    $.ajax({
        type: 'POST',
        url: server + getContentTypeList,
        data: {
            appID: appID,
            secret: secret,
            accessToken: accessToken
        },
        dataType: 'json',
        success: function (result) {
            if (result.status == 200) {
                //console.info(result);
                var $selContentType = $("#selContentType");
                var $ulCreateDropDown = $("#ulCreateDropDown");

                for(var i=0; i < result.data.length; i++){
                    var dictItem = result.data[i];
                    var $option = $("<option></option>");
                    $option.attr("value", dictItem.dictItemCode);
                    $option.text(dictItem.dictItemName);
                    $selContentType.append($option);

                    var $li = $("<li></li>");
                    var $a = $("<a></a>");
                    $li.append($a);
                    $a.attr("href", "#");
                    $a.text(dictItem.dictItemName);
                    $ulCreateDropDown.append($li);
                }
            }
        }
    });
}

function search(){
    var channelID = $("#selChannelList").val();
    var contentTitle = $("#inputContentTitle").val();
    var contentType = $("#selContentType").val();
    var startDate = $("#inputStartDate").val();
    var endDate = $("#inputEndDate").val();
    $.ajax({
        type: 'POST',
        url: server + searchContentList,
        data: {
            appID: appID,
            secret: secret,
            accessToken: accessToken,
            channelID: channelID,
            contentTitle: contentTitle,
            contentType: contentType,
            startDate: startDate,
            endDate: endDate
        },
        dataType: 'json',
        success: function (result) {
            if (result.status == 200) {
                console.info(result);
                var $tableSearcResult = $("#tableSearcResult");

                for(var i=0; i < result.data.length; i++){
                    var content = result.data[i];
                    var $tr = $("<tr></tr>");
                    var $tdContentID = $("<td>" + content.contentID + "</td>");
                    var $tdChannelID = $("<td>" + content.channelID + "</td>");
                    var $tdContentTitle = $("<td>" + content.contentTitle + "</td>");
                    var $tdStickyIndex = $("<td>" + content.stickyIndex + "</td>");
                    var $tdContentType = $("<td>" + content.contentType + "</td>");
                    var $tdCreateUserID = $("<td>" + content.createUserID + "</td>");
                    var $tdCreateTime = $("<td>" + content.createTime + "</td>");
                    var $tdPageViewCount = $("<td>" + content.pageViewCount + "</td>");
                    var $tdOption = $("<td>详细 | 删除</td>");

                    $tr.append($tdContentID);
                    $tr.append($tdChannelID);
                    $tr.append($tdContentTitle);
                    $tr.append($tdStickyIndex);
                    $tr.append($tdContentType);
                    $tr.append($tdCreateUserID);
                    $tr.append($tdCreateTime);
                    $tr.append($tdPageViewCount);
                    $tr.append($tdOption);

                    $tableSearcResult.append($tr);
                }
            }
        }
    });
}