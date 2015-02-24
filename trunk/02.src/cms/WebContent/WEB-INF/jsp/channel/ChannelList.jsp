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
<link type="text/css" rel="stylesheet" href="${SITE_URL}/css/channel/ChannelList.css">
<script type="text/javascript">
	$(function() {
		$("#tree").treeview({
			animated : "fast",
			persist : "location"
		});
	})

	function btnCreate(parentID) {
		window.form.action = "channelDetail.action?channel.parentID=" + parentID;
		window.form.submit();
	}
	
	function deleteChannel(parentChannelID, channelID, version){
		if (confirm("确定要删除该栏目吗？")) {
			window.location.href = "channelListDelete.action?parentChannelID="+parentChannelID+"&channel.channelID=" + channelID + "&version=" + version;
	    }
	}
</script>
</head>
<body>
	<s:form id="form">
		<jsp:include page="../include/Top.jsp"></jsp:include>
		<div class="body_wrap">
			<div class="left_side_wrap">
				<f:tree root="${rootTreeNode}" recursion="true" />
			</div>
			<div class="right_side_wrap">
				<div class="bread_crumb">
					<span>当前的位置：</span><span>栏目管理 - 栏目列表</span>
				</div>
				<div>
					<span class="info_message center">
						<s:actionerror/>
						<s:actionmessage />
					</span>
					<table class="grid">
						<tr>
							<th width="5%">ID</th>
							<th width="10%">栏目名称</th>
							<th width="10%">访问路径</th>
							<th width="5%">隐藏</th>
							<th width="10%">创建者</th>
							<th width="20%">创建时间</th>
							<th width="10%">更新者</th>
							<th width="20%">更新时间</th>
							<th width="10%">操作</th>
						</tr>
						<s:iterator id="channel" value="channelList" status="st">
							<tr>
								<td>${channel.channelID }</td>
								<td>
									<a href="channelDetail.action?channel.channelID=${channel.channelID }">
										${channel.channelName }
									</a>
								</td>
								<td>${channel.channelPath }</td>
								<td class="align_center">
									<s:if test="#channel.isHidden == 0">否</s:if>
									<s:else>是</s:else>
								</td>							
								<td class="align_center">${SECURITY_USERS_MAP[channel.createUser]}</td>
								<td class="align_center">${channel.createTime}</td>
								<td class="align_center">${SECURITY_USERS_MAP[channel.updateUser]}</td>
								<td class="align_center">${channel.updateTime}</td>
								<td class="align_center">
									<a href="channelListMove.action?direct=1&channelID=${channel.channelID }">上移</a>|
									<a href="channelListMove.action?direct=2&channelID=${channel.channelID }">下移</a>|
									<a href="#" onclick="return deleteChannel(${parentChannelID}, ${channel.channelID }, ${channel.version })">删除</a>
								</td>
							</tr>
						</s:iterator>
					</table>
					<div class="button_bar">
						<input type="button" class="button" onclick="btnCreate(${parentChannelID})" value="添加">
					</div>
				</div>
			</div>
		</div>
	</s:form>
</body>
</html>