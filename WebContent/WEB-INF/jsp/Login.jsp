<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="include/Header.jsp"></jsp:include>
<link type="text/css" rel="stylesheet" href="${SITE_URL}/css/Login.css">
<title>统一权限认证系统－用户登录</title>
<script type="text/javascript">
	function myReload() {
		document.getElementById("imgIdentityCode").src = document
				.getElementById("imgIdentityCode").src
				+ "?nocache=" + new Date().getTime();
	}
</script>
</head>
<body>
	<s:actionerror />
	<form action="login.action" method="post">
		<div class="auth_form">
			<div class="auth_form_header">
				<h1>用户登录</h1>
			</div>
			<div class="auth_form_body">
				<label>用户名：</label><br>
				<input class="input_text" type="text" name="loginID">
				<label>密码：</label><br>
				<input class="input_text" type="password"	name="password">
				<!-- <label>验证码：</label>
				<input class="input_text" type="text" name="identifyCode" maxlength="5">
				<img id="imgIdentityCode" src="identifyCode.action">
				<a href="#" onClick="myReload()">看不清，换一个</a>   -->
				<button id="btnLogin" type="submit">登录</button>
			</div>
		</div>
	</form>
</body>
</html>