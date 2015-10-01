<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="core" uri="/core-tags"%>
<%@ taglib prefix="cms" uri="/cms-tags"%>
<%@ taglib prefix="passport" uri="/passport-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../include/Header.jsp"></jsp:include>
<link type="text/css" rel="stylesheet" href="${SITE_URL}/css/index/Index.css">
</head>
<body>
	<jsp:include page="../include/Top.jsp"></jsp:include>
	<div class="page_content_wrap">
		<div class="page_content_left_wrap">
			<passport:subMenu title="我的工作台"/>
		</div>
		<div class="page_content_right_wrap">
			<passport:breadCrumb />
			<div class="page_content">
				<div class="page_content_list_item">欢迎&nbsp;${sessionScope.LOGIN_USER.userName}&nbsp;登录 IIDOOO多站点内容管理系统</div>
				<div class="page_content_list_item">您上次登录的时间是：${sessionScope.LOGIN_USER.loginTime }</div>
				<div class="page_content_list_item">当前的默认站点是：${sessionScope.SESSION_DEFAULT_SITE.siteName }</div>	
			</div>
		</div>
	</div>
</body>
</html>