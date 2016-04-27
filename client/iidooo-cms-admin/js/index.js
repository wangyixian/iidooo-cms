/**
 * Created by Ethan on 16/4/22.
 */
$(function () {
    var accessToken = $.cookie("ACCESS_TOKEN");
    if (accessToken == null) {
        location.href = client + "/login.html";
        return;
    }
    setUserInfo(accessToken);
    loadPage("/content-manage.html", "content-manage");
});

// 单页应用加载page
function loadPage(page, activeNavItem) {
    $('#page').load(client + page);
    setActiveNavItem(activeNavItem);
}

function setUserInfo(accessToken) {
    $.ajax({
        type: 'POST',
        url: server + "/admin/getUserByToken",
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

function setActiveNavItem(activeNavItem) {
    var activeLi = $('#navbar ' + '#' + activeNavItem);
    activeLi.addClass('active');
}