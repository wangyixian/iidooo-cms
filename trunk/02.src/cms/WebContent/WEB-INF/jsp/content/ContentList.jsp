<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="f" uri="/framework-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../include/Header.jsp"></jsp:include>
<script type="text/javascript" src="${SITE_URL}/js/lib/jquery.treeview/jquery.treeview.js"></script>
<script type="text/javascript" src="${SITE_URL}/js/lib/jquery.treeview/lib/jquery.cookie.js"></script>
<link type="text/css" rel="stylesheet" href="${SITE_URL}/js/lib/jquery.treeview/jquery.treeview.css">
<link type="text/css" rel="stylesheet" href="${SITE_URL}/css/content/ContentList.css">

<script type="text/javascript">
	$(function() {
		$("#tree").treeview({
			animated : "fast",
			persist : "location"
		});
	})
	
	function btnCreate(){
		var modelID = $("#selModel").val();
		var channelID = $("#hidChannelID").val();
		window.location.href = "contentDetail.action?content.modelID="+modelID+"&content.channelID=" + channelID;
	}
	
</script>
</head>
<body>
	<form id="form" action="" method="post">
		<jsp:include page="../include/Top.jsp"></jsp:include>
		<div class="body_wrap">
			<input id="hidChannelID" type="hidden" name="channelID" value="${channelID }">
			<div class="left_side_wrap">
				<f:tree root="${rootTreeNode}" recursion="true" />
			</div>
			<div class="right_side_wrap">
				<div class="bread_crumb">
					<span>当前的位置：</span><span>内容管理 - 内容列表</span>
				</div>
				<div>
					<select id="selModel">
						<option value="0">默认</option>
						<s:iterator value="fieldModelList" id="item" status="st">
						<option value="${item.modelID }">${item.modelName }</option>
						</s:iterator>
					</select>
					<input type="button" onclick="btnCreate()" value="发布">
				</div>
				<div class="block">
					<table class="grid">
						<tr>
							<th width="5%">ID</th>
							<th width="10%">栏目</th>
							<th width="25%">标题</th>
							<th width="10%">发布者</th>
							<th width="15%">发布时间</th>
							<th width="10%">更新者</th>
							<th width="15%">更新时间</th>
							<th width="10%">操作</th>
						</tr>
						<s:iterator id="content" value="contentList" status="st">
							<tr>
								<td class="align_center">${content.contentID}</td>
								<td>${content.channelName}</td>
								<td>
									<a href="contentDetail.action?content.contentID=${content.contentID }">
										${content.contentTitle}
									</a>
								</td>
								<td class="align_center">${SECURITY_USERS_MAP[content.createUser]}</td>
								<td class="align_center">${content.createTime}</td>
								<td class="align_center">${SECURITY_USERS_MAP[content.updateUser]}</td>
								<td class="align_center">${content.updateTime}</td>
								<td class="align_center"><a>浏览</a>|<a>上移</a>|<a>下移</a></td>
							</tr>
						</s:iterator>
					</table>
					<jsp:include page="../include/Paging.jsp"></jsp:include>
				</div>
			</div>
		</div>
	</form>
</body>
</html>