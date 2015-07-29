<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="core" uri="/core-tags"%>
<%@ taglib prefix="cms" uri="/cms-tags"%>
<%@ taglib prefix="passport" uri="/passport-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../include/Header.jsp"></jsp:include>
<jsp:include page="../include/Tree.jsp"></jsp:include>

<script type="text/javascript">
	function btnCreate(){
		var contentType = $("#selContentType").val();
		var siteID = $("#hidSiteID").val();
		$(location).attr('href',"contentDetail.action?content.siteID=" + siteID + "&content.contentType=" + contentType);
	}
	
	function deleteContent(contentID){
		if (confirm("确定要删除该内容吗？")) {
			$("#hidContentID").val(contentID);
			var $form = $("form");
			$form.attr("action","contentListDelete.action");
			$form.submit();
	    }
	}
</script>
</head>
<body>	
	<jsp:include page="../include/Top.jsp"></jsp:include>
	<div class="page_content_wrap">
		<div class="page_content_left_wrap">
			<cms:channelTree baseURL="contentList.action?content.siteID={0}&content.channelID={1}"/>
		</div>
		<div class="page_content_right_wrap">
			<passport:breadCrumb/>		
			<div class="page_content">
				<form id="form" action="" method="post">
					<s:actionerror />
					<s:actionmessage />
					<input id="hidSiteID" type="hidden" name="content.siteID" value="${content.siteID }">
					<input id="hidChannelID" type="hidden" name="content.channelID" value="${content.channelID }">
					<input id="hidContentID" type="hidden" name="content.contentID" value="${content.contentID }">
					<input id="hidContentTitle" type="hidden" name="content.contentTitle">
					<table class="datagrid">
						<tr>
							<th width="5%">ID</th>
							<th width="10%">栏目</th>
							<th width="33%">标题</th>
							<th width="5%">类型</th>
							<th width="5%">评论可否</th>
							<th width="8%">创建者</th>
							<th width="8%">创建日期</th>
							<th width="8%">更新者</th>
							<th width="8%">更新日期</th>
							<th width="5%">访问量</th>
							<th width="5%">操作</th>
						</tr>
						<s:iterator id="item" value="contentList" status="st">
							<tr>
								<td class="align_center">
									<a href="contentDetail.action?content.siteID=${content.siteID }&content.contentID=${item.contentID }"> ${item.contentID} </a>
								</td>
								<td class="align_center">${item.channelName}</td>
								<td><a href="contentDetail.action?content.siteID=${content.siteID }&content.contentID=${item.contentID }"> ${item.contentTitle} </a></td>
								<td class="align_center">
									<s:if test="#item.contentType == 1">默认</s:if>
									<s:if test ="#item.contentType == 2">产品</s:if>
								</td>
								<td class="align_center">
									<s:if test="#item.isSilent == 0">可</s:if>
									<s:if test="#item.isSilent == 1">否</s:if>
								</td>
								<td class="align_center">${item.createUserName }</td>
								<td class="align_center">${item.createDate }</td>
								<td class="align_center">${item.updateUserName }</td>
								<td class="align_center">${item.updateDate }</td>
								<td class="align_center">${item.pageViewed }</td>
								<td class="align_center">
									<a href="#" onclick="return deleteContent(${item.contentID})">删除</a>
								</td>
							</tr>
						</s:iterator>
					</table>
					<div class="button_bar">
						<core:dictItemSelect id="selContentType" name="content.contentType" dictClassCode="DICT_CLASS_CONTENT_TYPE"/>					
						<a href="#" class="button" onclick="btnCreate()">发布</a>
					</div>
					<div class="block">
						<hr>
					</div>
					<jsp:include page="../include/Paging.jsp"></jsp:include>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="../include/Footer.jsp"></jsp:include>
</body>
</html>