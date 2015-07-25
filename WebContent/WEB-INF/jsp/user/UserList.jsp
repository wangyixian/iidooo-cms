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
	function deleteContent(userID){
		if (confirm("确定要删除该用户吗？")) {
			$("#hidUserID").val(userID);
			window.form.action = "userListDelete.action";
			window.form.submit();
	    }
	}
</script>
</head>
<body>	
	<jsp:include page="../include/Top.jsp"></jsp:include>
	<div class="page_content_wrap">
		<div class="page_content_left_wrap">
			<passport:subMenu/>
		</div>
		<div class="page_content_right_wrap">
			<passport:breadCrumb/>		
			<div class="page_content">
				<form id="form" action="" method="post">
					<s:actionerror />
					<s:actionmessage />
					<%-- <input id="hidSiteID" type="hidden" name="content.siteID" value="${content.siteID }">
					<input id="hidChannelID" type="hidden" name="content.channelID" value="${content.channelID }">
					<input id="hidContentID" type="hidden" name="content.contentID" value="${content.contentID }">
					<input id="hidContentTitle" type="hidden" name="content.contentTitle"> --%>
					<input id="hidUserID" type="hidden" name="user.userID" value="${user.userID }">
					<table class="datagrid">
						<tr>
							<th width="45%">登录帐号</th>
							<th width="40%">用户名</th>
							<th width="15%">操作</th>
						</tr>
						<s:iterator id="item" value="userList" status="st">
							<tr>
								<td class="align_center">
									<a href="userDetail.action?user.userID=${item.userID }"> ${item.loginID} </a>
								</td>
								<td class="align_center">${item.userName}</td>				
								<td class="align_center">
									<a>上移</a>| 
									<a>下移</a>| 
									<a href="#" onclick="return deleteUser(${item.userID})">删除</a>
								</td>
							</tr>
						</s:iterator>
					</table>
					<div class="button_bar">
						<a class="button" href="userDetail.action">添加</a>
					</div>					
					<jsp:include page="../include/Paging.jsp"></jsp:include>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="../include/Footer.jsp"></jsp:include>
</body>
</html>