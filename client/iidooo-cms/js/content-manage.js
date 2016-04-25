/**
 * Created by Ethan on 16/4/22.
 */

$(function() {

    var accessToken = $.cookie("ACCESS_TOKEN");
    if (accessToken == null) {
        location.href = client + "/login.html";
        return;
    }

    initSelChannelList(accessToken);

    $('.form_date').datetimepicker({
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });
});

function initSelChannelList(accessToken){
    $.ajax({
        type: 'POST',
        url: server + "/admin/getChannelList",
        data: {
            appID: "CMSSystem",
            secret: "e96b669ba65848bcb20f5de53dcc370e",
            accessToken: accessToken
        },
        dataType: 'json',
        success: function (result) {
            if (result.status == 200) {
                $("#insertUserName").text(result.data.userName);

            } else {
                alert(result.status);
            }
        },
        error: function (result) {
            alert(result);
        }
    });
}
