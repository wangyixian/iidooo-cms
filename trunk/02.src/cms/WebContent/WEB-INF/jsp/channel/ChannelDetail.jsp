<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link type="text/css" rel="stylesheet" href="${SITE_URL}/css/channel/ChannelDetail.css">
<script type="text/javascript">
	$(function() {
		$("#tree").treeview({
			animated : "fast",
			persist : "location"
		});
	})

	function createChannel() {
		window.form.action = "channelCreate.action";
		window.form.submit();
	}

	function updateChannel() {
		window.form.action = "channelUpdate.action";
		window.form.submit();
	}

	function deleteChannel() {
		window.form.action = "channelDelete.action";
		window.form.submit();
	}

	function returnBack() {
		window.location.href = "channelList.action";
	}
</script>
</head>
<body>
	<jsp:include page="../include/Top.jsp"></jsp:include>
	<div class="body_wrap">
		<div class="left_side_wrap">
			<f:tree root="${rootTreeNode}" recursion="true" />
		</div>
		<div class="right_side_wrap">
			<div class="bread_crumb">
				<span>当前的位置：</span><span>栏目管理 - 栏目详细</span>
			</div>
			<div>
				<s:form id="form">
					<input type="hidden" name="channel.channelID" value="${channel.channelID }">
					<input type="hidden" name="channel.version"	value="${channel.version }">
					<table class="grid">
						<tr>
							<th class="required" width="10%">上级栏目</th>
							<td>
								<select name="channel.parentID">
									<option value="0">顶级栏目</option>
									<s:iterator value="allChannels" status="st" id="item">
										<s:if test="channel.parentID == #item.channelID">
											<option value="${item.channelID }" selected="selected">${item.channelName }</option>
										</s:if>
										<s:else>
											<option value="${item.channelID }">${item.channelName }</option>										
										</s:else>
									</s:iterator>
								</select>
							</td>
							<th class="required" width="10%">栏目模板</th>
							<td>
								<select name="channel.templateID">
									<s:iterator value="allTemplates" status="st" id="item">
										<s:if test="channel.templateID == #item.templateID">
											<option value="${item.templateID }" selected="selected">${item.templatePath }</option>
										</s:if>
										<s:else>
											<option value="${item.templateID }">${item.templatePath }</option>
										</s:else>
									</s:iterator>
							</select>
							</td>
						</tr>
						<tr>
							<th class="required">栏目名称</th>
							<td>
								<input type="text" name="channel.channelName" value="${channel.channelName}">
							</td>
							<th class="required">访问路径</th>
							<td>
								<input type="text" name="channel.channelPath" value="${channel.channelPath}">
							</td>
						</tr>
						<tr>
							<th>meta标题</th>
							<td>
								<input type="text" name="channel.metaTitle"	value="${channel.metaTitle}">
							</td>
							<th>meta关键字</th>
							<td>
								<input type="text" name="channel.metaKeywords" value="${channel.metaKeywords}">
							</td>
						</tr>
						<tr>
							<th>meta描述</th>
							<td colspan="3">
								<textarea rows="5" cols="100" name="channel.metaDescription">${channel.metaDescription }</textarea>
							</td>
						</tr>
						<tr>
							<th class="required">是否隐藏</th>
							<td colspan="3">
								<s:if test="channel.isHidden == 1">
									<input type="radio" name="channel.isHidden" value="0">显示
									<input type="radio" name="channel.isHidden" value="1" checked>隐藏		
								</s:if>
								<s:else>
									<input type="radio" name="channel.isHidden" value="0" checked>显示
									<input type="radio" name="channel.isHidden" value="1">隐藏
								</s:else>
							</td>
						</tr>
						<tr>
							<th>备注</th>
							<td colspan="3">
								<textarea rows="5" cols="100" name="channel.remarks">${channel.remarks }</textarea>
							</td>
						</tr>
					</table>
					<div class="button_bar">
						<s:if test="channel == null">
							<input type="button" value="创建" onclick="return createChannel();">
						</s:if>
						<s:else>
							<input type="button" value="更新" onclick="return updateChannel();">
							<input type="button" value="删除" onclick="return deleteChannel();">
						</s:else>
						<input type="button" value="返回" onclick="return returnBack();">
					</div>
				</s:form>
			</div>
		</div>
	</div>
</body>
</html>