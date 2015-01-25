<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../include/Header.jsp"></jsp:include>
<link type="text/css" rel="stylesheet" href="${SITE_URL}/css/content/ContentList.css">
</head>
<body>
<jsp:include page="../include/Top.jsp"></jsp:include>
	<div>
		<div class="left_side_wrap">树</div>
		<div class="right_side_wrap">
			<div class="block">
				<input type="button" onclick="btnCreate()" value="发布">
			</div>
			<div class="block">
				<table class="grid">
					<tr>
						<th width="5%">ID</th>
						<th width="35%">标题</th>
						<th width="10%">发布者</th>
						<th width="15%">发布时间</th>
						<th width="10%">更新者</th>
						<th width="15%">更新时间</th>
						<th width="10%">操作</th>
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
				<jsp:include page="../include/Paging.jsp"></jsp:include>
			</div>
		</div>
	</div>
</body>
</html>