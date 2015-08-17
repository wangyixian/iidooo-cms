<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="cms" uri="/cms-tags"%>
<%@ taglib prefix="passport" uri="/passport-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../include/Header.jsp"></jsp:include>
<jsp:include page="../include/Tree.jsp"></jsp:include>
<link type="text/css" rel="stylesheet" href="/cms/css/channel/ChannelDetail.css">
<script type="text/javascript">

	function createChannel() {
		var $form = $("form");
		$form.attr("action","channelCreate.action");
		$form.submit();
	}

	function updateChannel() {
		var $form = $("form");
		$form.attr("action","channelUpdate.action");
		$form.submit();
	}

	function deleteChannel() {
		var $form = $("form");
		$form.attr("action","channelDelete.action");
		$form.submit();
	}
	
/* 	function createSubChannel(parentID){
		window.location.href = "channelDetail.action?channel.parentID=" + parentID;
	} */

	function returnBack(parentID) {
		 $(location).attr('href',"channelList.action?channel.channelID=" + parentID);
		//window.location.href = "channelList.action?channel.channelID=" + parentID;
		
	}
</script>
</head>
<body>
	<jsp:include page="../include/Top.jsp"></jsp:include>
	<div class="page_content_wrap">
		<div class="page_content_left_wrap">
			<cms:channelTree baseURL="channelList.action?channel.channelID={0}" title="栏目树"/>
		</div>
		<div class="page_content_right_wrap">
			<passport:breadCrumb />
			<div class="page_content">
				<s:actionerror />
				<s:actionmessage />
				<form id="form" method="post">
					<input type="hidden" name="channel.channelID" value="${channel.channelID }">
					<input type="hidden" name="channel.version"	value="${channel.version }">
					<input type="hidden" name="channel.siteID"	value="${sessionScope.SESSION_DEFAULT_SITE.siteID }">
					<input type="hidden" name="channel.sequence" value="${channel.sequence }">
					<table class="datagrid">
						<tr>
							<th width="90px">当前站点</th>
							<td>${sessionScope.SESSION_DEFAULT_SITE.siteName }</td>
						</tr>
						<tr>
							<th width="90px">上级栏目</th>
							<td>
								<cms:channelSelect name="channel.parentID" id="selChannel" value="${channel.parentID}"/>
							</td>
						</tr>
						<tr>
							<th width="10%">菜单显示</th>
							<td><s:if test="channel.isHidden == '1'">
									<input type="radio" name="channel.isHidden" value="0">
									<label class="radio_label">显示</label>
									<input type="radio" name="channel.isHidden" value="1" checked>
									<label class="radio_label">隐藏</label>
								</s:if> <s:else>
									<input type="radio" name="channel.isHidden" value="0" checked>
									<label class="radio_label">显示</label>
									<input type="radio" name="channel.isHidden" value="1">
									<label class="radio_label">隐藏</label>
								</s:else></td>
						</tr>
						<tr>
							<th>栏目名称</th>
							<td><input type="text" class="input_text" style="width: 250px" name="channel.channelName" value="${channel.channelName}"></td>

						</tr>
						<tr>
							<th>栏目路径</th>
							<td><input type="text" class="input_text" style="width: 250px" name="channel.channelPath" value="${channel.channelPath}"></td>
						</tr>
						<tr>
							<th>meta标题</th>
							<td><input type="text" class="input_text" style="width: 250px" name="channel.metaTitle" value="${channel.metaTitle}"></td>

						</tr>
						<tr>
							<th>meta关键字</th>
							<td><input type="text" class="input_text" style="width: 250px" name="channel.metaKeywords" value="${channel.metaKeywords}"></td>
						</tr>
						<tr>
							<th>meta描述</th>
							<td><textarea class="input_text" style="width: 500px; height: 100px;" name="channel.metaDescription">${channel.metaDescription }</textarea></td>
						</tr>
						<tr>
							<th>备注</th>
							<td><textarea class="input_text" style="width: 500px; height: 100px;" name="channel.remarks">${channel.remarks }</textarea></td>
						</tr>
					</table>
					<div class="button_bar">
						<s:if test="channel == null || channel.channelID == null || channel.channelID <= 0">
							<button type="button" onclick="return createChannel();">创建</button>
						</s:if>
						<s:else>
							<button type="button" onclick="return updateChannel();">更新</button>
							<%-- <button type="button" onclick="createSubChannel(${channel.channelID});">添加子栏目</button> --%>
						</s:else>
						<button type="button" onclick="return returnBack(${channel.parentID});">返回</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>