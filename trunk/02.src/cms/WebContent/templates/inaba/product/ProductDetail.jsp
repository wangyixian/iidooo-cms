<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="cms" uri="/cms-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="${content.metaKeywords}" >
<meta name="description" content="${content.metaDescription}">
<jsp:include page="../include/Head.jsp"></jsp:include>
<link type="text/css" rel="stylesheet" href="${SITE_TEMPLATE_URL}/res/css/product/ProductDetail.css">
</head>
<body>
	<jsp:include page="../include/Top.jsp"></jsp:include>
	<div class="body_wrap">		
    	<cms:mainmenu channelPath="productList" />
	</div>
	<div class="body_wrap block shadow">
	    <div class="content_wrap">
			<div class="content">
				<h1>${content.contentTitle }</h1>
				<hr class="hr"></hr>
				<hr size="2" width="100%">
				<div>					
					${content.contentBody }
				</div>
			</div>
		</div>
	</div>
   <jsp:include page="../include/Footer.jsp"></jsp:include>	
</body>
</html>