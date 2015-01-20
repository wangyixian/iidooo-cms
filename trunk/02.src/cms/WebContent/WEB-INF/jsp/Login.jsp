<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="include/Header.jsp"></jsp:include>
<link type="text/css" rel="stylesheet" href="${SITE_URL}/css/Login.css">
<script type="text/javascript">
function login(){
	window.form.submit();
	return true;
}
</script>
</head>
<body>
	<div class="body_wrap">
		<form id="form" action="login.action" method="post">
			<div class="auth_form">
				<div class="auth_form_header">
					<h1>IIDOOO CMS 后台管理登录</h1>
				</div>
				<div class="auth_form_body">
					<label>用户名：</label>
					<input class="input_text" type="text" name="securityUser.loginID">
					<label>密码：</label>
					<input class="input_text" type="password" name="securityUser.password">
					<button id="btnLogin" onclick="return login()">登录</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>