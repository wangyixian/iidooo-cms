<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="maximum-scale=1.0, minimum-scale=1.0, user-scalable=0, initial-scale=1.0, width=device-width" />
<meta name="format-detection" content="telephone=no, email=no, date=no, address=no">
<title>毒电波</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/api.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/libs/showdown/showdown.min.js"></script>
</head>
<body>
	<div class="area1">
		<div class="title">${content.contentTitle}</div>
		<div id="insert" class="content">${content.contentBody}</div>
	</div>
	<div class="area2">
		<img src="<%=request.getContextPath()%>/resources/img/logo-small.png"><span>毒电波APP-有毒的负能量平台</span>
	</div>
</body>
<script>
	var converter = new showdown.Converter();
	var text = document.getElementById("insert").innerHTML;	
	var html = converter.makeHtml(text);
	document.getElementById("insert").innerHTML = html;
</script>
</html>