<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="cms" uri="/cms-tags"%>
<%@ taglib prefix="core" uri="/core-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../include/Header.jsp"></jsp:include>
<jsp:include page="../include/Tree.jsp"></jsp:include>
<link type="text/css" rel="stylesheet" href="/iidooo-cms/css/channel/ChannelList.css">
<script type="text/javascript">	
	$(function() {
		var $tree = $("#tree");
		if ($tree != null) {
			$tree.treeview({
				animated : "fast",
				persist : "location"
			});
		}
	})

	function deleteChannel(channelID){
		if (confirm("确定要删除该栏目吗？")) {
			$("#hidChannelID").val(channelID);
			var $form = $("form");
			$form.attr("action","channelDelete.action");
			$form.submit();
	    }
	}
</script>
</head>
<body>
	<jsp:include page="../include/Top.jsp"></jsp:include>
	<div class="page-content-wrap">
		<div class="page-content-left-wrap">
			<core:tree id="tree" cssClass="filetree" root="${root }" />
		</div>
		<div class="page-content-right-wrap">
			<core:breadCrumb />
			<div class="page_content">
				<form id="form" action="" method="post">
					<s:actionerror />
					<input id="hidChannelID" type="hidden" name="channel.channelID" value="${channel.channelID }">
					<input id="hidParentID" type="hidden" name="channel.parentID" value="${channel.parentID }">
					<table class="datagrid list">
						<tr>
							<th width="5%">ID</th>
							<th width="10%">栏目名称</th>
							<th width="10%">访问路径</th>
							<th width="30%">Meta标题</th>
							<th width="30%">Meta关键字</th>
							<th width="15%">操作</th>
						</tr>
						<s:iterator id="item" value="channelList" status="st">
							<tr>
								<td class="align_center"><a href="channelDetail.action?channel.channelID=${item.channelID }"> ${item.channelID } </a></td>
								<td class="align_center"><a href="channelDetail.action?channel.channelID=${item.channelID }"> ${item.channelName } </a></td>
								<td class="align_center">${item.channelPath }</td>
								<td class="align_center">${item.metaTitle}</td>
								<td class="align_center">${item.metaKeywords}</td>
								<td class="align_center">
									<a href="channelDetail.action?channel.channelID=${item.channelID }">详细</a> | 
									<a href="#">上移</a> | <a href="#">下移</a> | 
									<a href="#" onclick="return deleteChannel(${item.channelID })">删除</a>
								</td>
							</tr>
						</s:iterator>
					</table>
					<div class="button-bar">
						<a class="button" href="channelDetail.action?channel.parentID=${channel.parentID}">添加</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="../include/Footer.jsp"></jsp:include>
</body>
</html>