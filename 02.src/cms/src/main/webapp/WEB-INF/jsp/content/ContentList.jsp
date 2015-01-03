<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../include/Header.jsp"></jsp:include>
<link type="text/css" rel="stylesheet" href="${SITE_URL}/css/ContentList.css">
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
						<th>ID</th>
						<th>标题</th>
						<th>发布者</th>
						<th>发布时间</th>
						<th>更新者</th>
						<th>更新时间</th>
						<th>点击</th>
						<th>操作</th>
					</tr>
					<s:iterator id="content" value="contentList" status="st">
						<tr>
							<td class="align_center">${content.contentID}</td>
							<td>${content.contentTitle}</td>
							<td class="align_center">${content.createUser}</td>
							<td class="align_center">${content.createDate}</td>
							<td class="align_center">${content.updateUser}</td>
							<td class="align_center">${content.updateDate}</td>
							<td class="align_center"><a>查看</a>|<a>修改</a>|<a>删除</a></td>
						</tr>
					</s:iterator>
				</table>
				<button onclick="btnCreate()">添加</button>
			</div>
		</div>
	</div>
</body>
</html>