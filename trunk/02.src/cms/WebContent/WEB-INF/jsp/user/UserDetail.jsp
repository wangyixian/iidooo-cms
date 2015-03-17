<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../include/Header.jsp"></jsp:include>
<link type="text/css" rel="stylesheet" href="${SITE_URL}/css/user/UserDetail.css">
</head>
<body>
	<form id="form" method="post">
		<jsp:include page="../include/Top.jsp"></jsp:include>
		<div id="page" class="body_wrap">
			<div class="left_side_wrap">	
				<div class="tree_wrap">		
					<div class="title">用户管理</div>
					<ul class="content">
						<li class="content_item"><a href="userList.action">用户一览</a></li>
						<li class="content_item focus"><a href="userDetail.action">个人信息</a></li>
						<li class="content_item"><a href="userList.action">密码修改</a></li>
					</ul>
				</div>
			</div>
			<div class="right_side_wrap">
				<div class="bread_crumb">
					<span>当前的位置：</span>
					<span>用户管理 - 用户详细信息</span>							
				</div>
				<div class="content_wrap">				
					<table class="grid">
						<tr>
							<th width="10%">用户ID</th>
							<td>
								<input type="text" name="user.loginID" value="${user.loginID}">
							</td>
							<th width="10%">用户名</th>
							<td>
								<input type="text" name="user.userName" value="${user.userName}">
							</td>
						</tr>		
						<tr>
							<th width="10%">性别</th>
							<td>
								<s:if test="user.sex == 1">
								<input type="radio" name="user.sex" value="1" checked>男性
								<input type="radio" name="user.sex" value="2">女性
								</s:if>
								<s:else>
								<input type="radio" name="user.sex" value="1">男性
								<input type="radio" name="user.sex" value="2" checked>女性								
								</s:else>
							</td>
							<th width="10%">生日</th>
							<td>
								<input type="text" name="user.birthday" value="${user.birthday}">
							</td>
						</tr>	
						<tr>
							<th width="10%">电子邮箱</th>
							<td>
								<input type="text" name="user.email" value="${user.email}">
							</td>
							<th width="10%">微信号</th>
							<td>
								<input type="text" name="user.weChart" value="${user.weChart}">
							</td>
						</tr>	
						<tr>
							<th width="10%">电话</th>
							<td colspan="3">
								<input type="text" name="user.telphone" value="${user.telphone}">
							</td>
						</tr>	
						<tr>
							<th width="10%">描述</th>
							<td colspan="3">
								<textarea class="width_90per" rows="5" name="user.description">${user.description }</textarea>
							</td>
						</tr>		
						<tr>
							<th width="10%">备注</th>
							<td colspan="3">
								<textarea class="width_90per" rows="5" name="user.remarks">${user.remarks }</textarea>
							</td>
						</tr>					
					</table>					
					<div class="button_bar">
						<button type="button">添加</button>
						<button type="button">修改</button>
						<button type="button">删除</button>
						<button type="button">返回</button>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="../include/Footer.jsp"></jsp:include>
	</form>
</body>
</html>