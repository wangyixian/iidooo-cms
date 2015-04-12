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
	
	function createSubChannel(parentID){
		window.location.href = "channelDetail.action?channel.parentID=" + parentID;
	}

	function returnBack(parentID) {
		window.location.href = "channelList.action?parentChannelID=" + parentID;
	}
</script>
</head>
<body>
	<form id="form" method="post">
		<input type="hidden" name="channel.channelID" value="${channel.channelID }">
		<input type="hidden" name="channel.version"	value="${channel.version }">
		<jsp:include page="../include/Top.jsp"></jsp:include>
		<div id="page">
			<div class="left_side_wrap">
				<f:tree root="${rootTreeNode}" recursion="true"  title="栏目树"/>
			</div>
			<div class="right_side_wrap">
				<div class="bread_crumb">
					<span>当前的位置：</span><span>栏目管理 - 栏目更新</span>
				</div>
				<div class="content_wrap">					
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
							<th class="required" width="10%">菜单显示</th>
							<td>
								<s:if test="channel.isHidden == '1'">
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
							<th class="required">栏目名称</th>
							<td>
								<input type="text" class="width_400px" name="channel.channelName" value="${channel.channelName}">
							</td>
							<th class="required">访问路径</th>
							<td>
								<input type="text" class="width_400px" name="channel.channelPath" value="${channel.channelPath}">
							</td>
						</tr>
						<tr>
							<th>meta标题</th>
							<td>
								<input type="text" class="width_400px" name="channel.metaTitle"	value="${channel.metaTitle}">
							</td>
							<th>meta关键字</th>
							<td>
								<input type="text" class="width_400px" name="channel.metaKeywords" value="${channel.metaKeywords}">
							</td>
						</tr>
						<tr>
							<th>meta描述</th>
							<td colspan="3">
								<textarea rows="5" cols="100" name="channel.metaDescription">${channel.metaDescription }</textarea>
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
						<s:if test="channel == null || channel.channelID == null || channel.channelID <= 0">
							<button type="button" onclick="return createChannel();">创建</button>
						</s:if>
						<s:else>
							<button type="button" onclick="return updateChannel();">更新</button>
							<button type="button" onclick="return deleteChannel();">删除</button>
							<button type="button" onclick="createSubChannel(${channel.channelID});">添加子栏目</button>
						</s:else>
						<button type="button" onclick="return returnBack(${channel.parentID});">返回</button>
					</div>					
				</div>
			</div>
		</div>		
		<jsp:include page="../include/Footer.jsp"></jsp:include>
	</form>
</body>
</html>