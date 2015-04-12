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
		var contentType = $("#selContentType").val();
		var channelID = $("#hidChannelID").val();
		window.location.href = 
			"contentDetail.action?content.contentType="+contentType+"&content.channelID=" + channelID+"&mode=1";
	}
	
	function deleteContent(contentID){
		if (confirm("确定要删除该内容吗？")) {
			$("#hidContentID").val(contentID);
			window.form.action = "contentListDelete.action";
			window.form.submit();
	    }
	}
</script>
</head>
<body>
	<form id="form" method="post">
		<input id="hidChannelID" type="hidden" name="channelID" value="${channelID }">
		<input id="hidContentID" type="hidden" name="contentID">
		<jsp:include page="../include/Top.jsp"></jsp:include>
		<div id='page' class="body_wrap">
			<div class="left_side_wrap">
				<f:tree root="${rootTreeNode}" recursion="true" title="栏目树"/>
			</div>
			<div class="right_side_wrap">
				<div class="bread_crumb">
					<span>当前的位置：</span><span>内容管理 - 内容列表</span>
				</div>
				<div class="content_wrap">				
					<table class="grid">
						<tr>
							<th width="5%">ID</th>
							<th width="10%">栏目</th>
							<th width="23%">标题</th>
							<th width="6%">类型</th>
							<th width="10%">发布者</th>
							<th width="12%">发布时间</th>
							<th width="10%">更新者</th>
							<th width="12%">更新时间</th>
							<th width="12%">操作</th>
						</tr>
						<s:iterator value="contentList" id="item" status="st">
							<tr>
								<td class="align_center">
									<a href="contentDetail.action?content.contentID=${item.contentID }&mode=2">
									${item.contentID}
									</a>
								</td>
								<td>${item.channelName}</td>
								<td>
									<a href="contentDetail.action?content.contentID=${item.contentID }&mode=2">
										${item.contentTitle}
									</a>
								</td>
								<td class="align_center">${CONTENT_TYPE_MAP[item.contentType]}</td>
								<td class="align_center">${SECURITY_USERS_MAP[item.createUser]}</td>
								<td class="align_center">${item.createTime}</td>
								<td class="align_center">${SECURITY_USERS_MAP[item.updateUser]}</td>
								<td class="align_center">${item.updateTime}</td>
								<td class="align_center">
									<a>上移</a>|
									<a>下移</a>|
									<a href="#" onclick="return deleteContent(${item.contentID})">删除</a>								
								</td>
							</tr>
						</s:iterator>
					</table>
					
					<div class="button_bar">
						<select id="selContentType" name="content.contentType">
							<s:iterator value="#application.CONTENT_TYPE_LIST" id="item" status="st">
							<option value="${item.dictItemCode }">${item.dictItemName }</option>
							</s:iterator>
						</select>
						<button type="button" onclick="btnCreate()">发布</button>
					</div>
					<div class="block">
						<hr>
					</div>
					<jsp:include page="../include/Paging.jsp"></jsp:include>
				</div>
			</div>
		</div>
	<jsp:include page="../include/Footer.jsp"></jsp:include>
	</form>
</body>
</html>