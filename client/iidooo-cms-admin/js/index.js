/**
 * Created by Ethan on 16/4/22.
 */
$(function () {
    accessToken = $.cookie("ACCESS_TOKEN");
    if (accessToken == null) {
        location.href = client + "/login.html";
        return;
    }
    userID = $.cookie("USER_ID");
    setUserInfo(accessToken);
    loadPage("/content-manage.html", "content-manage");
});

// 单页应用加载page
function loadPage(page, activeNavItem) {
    //console.log("load page start.");
    $('#page').load(client + page);
    setActiveNavItem(activeNavItem);
}

function setUserInfo(accessToken) {
    $.ajax({
        type: 'POST',
        url: serverURL + getUserByTokenURL,
        data: {
            appID: appID,
            secret: secret,
            accessToken: accessToken
        },
        dataType: 'json',
        success: function (result) {
            if (result.status == 200) {
                $("#insertUserName").text(result.data.userName);

            } else {
                console.log(result);
            }
        },
        error: function (result) {
            console.log(result);
        }
    });
}

function setActiveNavItem(activeNavItem) {
    var activeLi = $('#navbar ' + '#' + activeNavItem);
    activeLi.addClass('active');
}

function logout() {
    $.cookie("ACCESS_TOKEN", null);
    $.cookie("USER_ID", null);
    accessToken = "";
    userID = "";
    location.href = client + "/login.html";
}