<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="cms" uri="/cms-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="${channel.metaKeywords}" >
<meta name="description" content="${channel.metaDescription}">
<jsp:include page="../include/Head.jsp"></jsp:include>
<link type="text/css" rel="stylesheet" href="${SITE_TEMPLATE_URL}/res/css/join/Join.css">
</head>
<body>
	<input id="hidChannelID" type="hidden" name="channel.channelID" value="${channel.channelID }">
	<jsp:include page="../include/Top.jsp"></jsp:include>
	<div class="body_wrap">		
    	<cms:mainmenu channelPath="join" />
	</div>
	<div class="body_wrap block shadow">
		<div class="content_wrap">
			<div class="content align_center">
				<h1>${content.contentTitle }</h1>
				<hr class="hr"></hr>
				<hr size="2" width="100%">
				<div>
					<img class="logo_square" alt="${SITE_NAME}" src="${SITE_TEMPLATE_URL}/res/img/logo_square.jpg"><br>
				</div>
			</div>
			<div class="content">
				${content.contentBody }
			</div>
		</div>
	</div>
   <jsp:include page="../include/Footer.jsp"></jsp:include>	
</body>
</html>