<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../include/Header.jsp"></jsp:include>
<link type="text/css" rel="stylesheet" href="${SITE_URL}/css/ChannelCreate.css">
</head>
<body>
	<jsp:include page="../include/Top.jsp"></jsp:include>
	<div>
		<div class="left_side_wrap">树</div>
		<div class="right_side_wrap">
			<div></div>
			<div class="block">
				<table class="grid">
					<tr>
						<th>栏目名称</th>
						<td><input type="text" name="channel.channelName"></td>
						<th>访问路径</th>
						<td><input type="text" name="channel.channelPath"></td>
					</tr>
					<tr>
						<th>meta标题</th>
						<td><input type="text" name="channel.metaTitle"></td>
						<th>meta关键字</th>
						<td><input type="text" name="channel.metaKeywords"></td>
					</tr>
					<tr>
						<th>meta描述</th>
						<td colspan="3"><textarea rows="5" cols="100"></textarea></td>
					</tr>
					<tr>
						<th>上级栏目</th>
						<td>${channel.parentID}</td>
						<th>栏目模板</th>
						<td><%-- <s:select list="templateList"></s:select> --%></td>
					</tr>
					<tr>
						<th>是否隐藏</th>
						<td><input type="radio">显示<input type="radio">隐藏</td>
						<th>外部链接</th>
						<td><input type="text" name="channel.externalURL"></td>
					</tr>
				</table>
				<input type="button" value="创建">
				<input type="button" value="重置">
			</div>
		</div>
	</div>
</body>
</html>