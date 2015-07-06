<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="cms" uri="/cms-tags"%>
<%@ taglib prefix="passport" uri="/passport-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../include/Header.jsp"></jsp:include>
<jsp:include page="../include/Tree.jsp"></jsp:include>
<link type="text/css" rel="stylesheet" href="/cms/css/channel/ChannelList.css">
<script type="text/javascript">	
	function deleteChannel(parentChannelID, channelID, version){
		if (confirm("确定要删除该栏目吗？")) {
			window.location.href = "channelListDelete.action?parentChannelID="+parentChannelID+"&channel.channelID=" + channelID + "&version=" + version;
	    }
	}
</script>
</head>
<body>
	<jsp:include page="../include/Top.jsp"></jsp:include>
	<div class="page_content_wrap">
		<div class="page_content_left_wrap">			
			<cms:channelTree baseURL="channelList.action?channel.channelID={0}&channel.siteCode={1}" />
		</div>
		<div class="page_content_right_wrap">
			<passport:breadCrumb/>
			<div class="page_content">
				<s:actionerror/>
				<s:actionmessage/>
				<table class="list">
					<tr>
						<th width="5%">ID</th>
						<th width="10%">栏目名称</th>
						<th width="10%">访问路径</th>
						<th width="5%">隐藏</th>
						<th width="30%">Meta标题</th>
						<th width="30%">Meta关键字</th>
						<th width="10%">操作</th>
					</tr>
					<s:iterator id="item" value="channelList" status="st">
						<tr>
							<td class="align_center">
								<a href="channelDetail.action?channel.channelID=${item.channelID }" target="_blank">
									${item.channelID }
								</a>
							</td>
							<td class="align_center">
								<a href="channelDetail.action?channel.channelID=${item.channelID }" target="_blank">
									${item.channelName }
								</a>
							</td>
							<td class="align_center">${item.channelPath }</td>
							<td class="align_center">
								<s:if test="#item.isHidden == 0">否</s:if>
								<s:else>是</s:else>
							</td>							
							<td class="align_center">${item.metaTitle}</td>
							<td class="align_center">${item.metaKeywords}</td>
							<td class="align_center">
								<a href="#">上移</a>|
								<a href="#">下移</a>|
								<a href="#" onclick="return deleteChannel(${parentChannelID}, ${item.channelID }, ${item.version })">删除</a>
							</td>
						</tr>
					</s:iterator>
				</table>
				<div class="button_bar">
					<a class="button" href="channelDetail.action?channel.parentID=${parentChannelID}" target="_blank">添加</a>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../include/Footer.jsp"></jsp:include>
</body>
</html>