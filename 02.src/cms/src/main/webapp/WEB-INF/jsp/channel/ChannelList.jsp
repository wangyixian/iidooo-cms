<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../include/Header.jsp"></jsp:include>
<link type="text/css" rel="stylesheet" href="${SITE_URL}/css/ChannelList.css">
<script type="text/javascript">
	function btnCreate() {
		window.location.href = "channelCreateInit.action";
	}
</script>
</head>
<body>
	<jsp:include page="../include/Top.jsp"></jsp:include>
	<div>
		<div class="left_side_wrap">树</div>
		<div class="right_side_wrap">
			<div></div>
			<div class="block">
				<table class="grid">
					<tr>
						<th>ID</th>
						<th>栏目名称</th>
						<th>访问路径</th>
						<th>是否隐藏</th>
						<th>更新时间</th>
						<th>更新者</th>
						<th>操作</th>
					</tr>
					<s:iterator id="channel" value="channelList" status="st">
						<tr>
							<td>${channel.channelID }</td>
							<td>${channel.channelName }</td>
							<td>${channel.channelPath }</td>
							<td class="align_center">${channel.isHidden }</td>
							<td class="align_center">${channel.updateTime}</td>
							<td class="align_center">${channel.updateUser}</td>
							<td class="align_center">
								<a>修改</a>|<a>删除</a>|<a>上移</a>|<a>下移</a>
							</td>
						</tr>
					</s:iterator>
				</table>
				<input type="button" onclick="btnCreate()" value="添加">
			</div>
		</div>
	</div>
</body>
</html>