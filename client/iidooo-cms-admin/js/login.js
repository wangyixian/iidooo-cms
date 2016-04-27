/**
 * Created by Ethan on 16/4/22.
 */
function login() {
    var loginID = $("#inputLoginID").val();
    var password = $("#inputPassword").val();
    $.ajax({
        type: 'POST',
        url: server + "/admin/getAccessToken",
        data: {
            appID: appID,
            secret: secret,
            loginID: loginID,
            password: password
        },
        dataType: 'json',
        success: function (result) {
            if(result.status == 200){
                // 当没有指明 cookie有效时间时，所创建的cookie有效期默认到用户关闭浏览器为止，所以被称为“会话cookie（session cookie）”。
                $.cookie("ACCESS_TOKEN", result.data.token, {expires:1});

                location.href = client + "/index.html";

            } else{
                alert(result.status);
            }
        },
        error: function(result){
            alert(result);
        }
    });
}