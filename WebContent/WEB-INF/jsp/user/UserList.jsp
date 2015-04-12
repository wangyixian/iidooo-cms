<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../include/Header.jsp"></jsp:include>
<link type="text/css" rel="stylesheet" href="${SITE_URL}/css/user/UserList.css">
</head>
<body>
	<form id="form" method="post">
		<jsp:include page="../include/Top.jsp"></jsp:include>
		<div id="page" class="body_wrap">
			<div class="left_side_wrap">	
				<div class="tree_wrap">		
					<div class="title">用户管理</div>
					<ul class="content">
						<li class="content_item focus"><a href="userList.action">用户一览</a></li>
						<li class="content_item"><a href="userDetail.action">个人信息</a></li>
						<li class="content_item"><a href="userList.action">密码修改</a></li>
					</ul>
				</div>
			</div>
			<div class="right_side_wrap">
				<div class="bread_crumb">
					<span>当前的位置：</span>
					<span>用户管理 - 用户一览</span>			
				</div>
				<div class="content_wrap">				
					<table class="grid">
						<tr>
							<th width="10%">ID</th>
							<th width="20%">用户名</th>
							<th width="20%">角色</th>
							<th width="20%">最后登录时间</th>
							<th width="10%">是否禁用</th>
							<th width="20%">操作</th>
						</tr>
						<s:iterator value="users" id="item" status="st">
							<tr>
								<td>
									<%-- <a href="userDetail.action?user.userID=${item.userID }"> --%>
										${item.userID }
									<!-- </a> -->
								</td>
								<td>
									<%-- <a href="userDetail.action?user.userID=${item.userID }"> --%>
										${item.userName }
									<!-- </a> -->
								</td>
								<td>${item.roleName }</td>
								<td class="align_center">
									${item.loginTime }
								</td>							
								<td class="align_center">
								<s:if test="#item.isDisable == 0">有效</s:if>
								<s:else>无效</s:else>
								</td>
								<td class="align_center">
									<a href="">详细</a>|
									<a href="#" onclick="return deleteUser(${item.userID}, ${channel.version })">删除</a>
								</td>
							</tr>
						</s:iterator>
					</table>
									
					<div class="button_bar">
						<button type="button" onclick="btnCreate(${parentChannelID})">添加</button>
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