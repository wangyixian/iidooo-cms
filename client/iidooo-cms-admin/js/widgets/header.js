/**
 * Created by Ethan on 16/4/6.
 */
$(function () {
    $('header').load(client + '/widgets/header.html');

    accessToken = $.cookie("ACCESS_TOKEN");
    if (accessToken == null) {
        location.href = client + "/login.html";
        return;
    }
    userID = $.cookie("USER_ID");
    setUserInfo();
});

function setUserInfo() {
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