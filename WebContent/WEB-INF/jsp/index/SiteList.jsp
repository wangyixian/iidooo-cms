<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="core" uri="/core-tags"%>
<%@ taglib prefix="cms" uri="/cms-tags"%>
<%@ taglib prefix="passport" uri="/passport-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../include/Header.jsp"></jsp:include>
<link type="text/css" rel="stylesheet" href="${SITE_URL}/css/site/SiteList.css">
</head>
<body>
	<jsp:include page="../include/Top.jsp"></jsp:include>
	<div class="page_content_wrap">
		<div class="page_content_left_wrap">
			<passport:subMenu title="我的工作台"/>
		</div>
		<div class="page_content_right_wrap">
			<passport:breadCrumb />
			<div class="page_content">
				<form id="form" action="" method="post">
					<s:actionerror />
					<s:actionmessage />					
					<table class="datagrid">
						<tr>
							<th width="5%">ID</th>
							<th width="10%">站点编码</th>
							<th width="20%">站点名称</th>
							<th width="20%">站点路径</th>
							<th width="10%">创建者</th>
							<th width="10%">创建日期</th>
							<th width="10%">更新者</th>
							<th width="10%">更新日期</th>
							<th width="5%">操作</th>
						</tr>
						<s:iterator id="item" value="#session.SESSION_SITE_LIST" status="st">
							<tr>
								<td class="align_center"><a href="siteDetail.action?site.siteID=${item.siteID }">${item.siteID}</a></td>
								<td>${item.siteCode}</td>
								<td><a href="siteDetail.action?site.siteID=${item.siteID }">${item.siteName}</a></td>
								<td><a href="${item.siteURL }" target="_blank">${item.siteURL}</a></td>								
								<td class="align_center">${item.createUserName }</td>
								<td class="align_center">${item.createDate }</td>
								<td class="align_center">${item.updateUserName }</td>
								<td class="align_center">${item.updateDate }</td>
								<td class="align_center"><a href="#" onclick="return deleteContent(${item.siteID})">删除</a></td>
							</tr>
						</s:iterator>
					</table>
					<div class="button_bar">
						<a href="#" class="button" onclick="btnCreate()">新建</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>