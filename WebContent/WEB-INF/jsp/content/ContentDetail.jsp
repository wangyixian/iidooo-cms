<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="core" uri="/core-tags"%>
<%@ taglib prefix="cms" uri="/cms-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../include/Header.jsp"></jsp:include>
<script type="text/javascript" src="${CORE_URL}/js/KindEditor/kindeditor-min.js"></script>
<script type="text/javascript" src="${CORE_URL}/js/KindEditor/lang/zh_CN.js"></script>
<script type="text/javascript" src="${CORE_URL}/js/jquery.treeview/jquery.treeview.js"></script>
<script type="text/javascript" src="${CORE_URL}/js/jquery.treeview/lib/jquery.cookie.js"></script>
<link type="text/css" rel="stylesheet" href="${CORE_URL}/js/jquery.treeview/jquery.treeview.css">

<script type="text/javascript" src="js/content/ContentDetail.js"></script>
<link type="text/css" rel="stylesheet" href="css/content/ContentDetail.css">

</head>
<body>	
	<jsp:include page="../include/Top.jsp"></jsp:include>		
	<div id="page_content_wrap">	
		<div class="page_content_left_wrap">
			<cms:channelTree baseURL="contentList.action?content.channelID=" title="栏目树" />
		</div>
		<div class="page_content_right_wrap">		
			<div class="bread_crumb">
				<span>当前的位置：</span>
				<s:if test="content.contentID == null">
					<span>内容管理 - 内容创建</span>
				</s:if>
				<s:else>
					<span>内容管理 - 内容详细</span>
				</s:else>
			</div>
			<div class="page_content">
				<form id="form" method="post">					
					<input id="hidChannelID" type="hidden" value="${content.channelID }">
					<input type="hidden" name="content.contentID" value="${content.contentID}">
					<input type="hidden" name="content.contentType" value="${content.contentType }">
					<input type="hidden" name="content.version"	value="${content.version }">		
					<table class="detail">
						<tr>							
							<th width="10%">内容类型</th>		
							<td>
								<core:dictItem id="selContentType" name="content.contentType" dictClassCode="CONTENT_TYPE" value="${content.contentType }" isDiabled="true"/>	
							</td>		
							<th width="10%">所属栏目</th>
							<td>
								<cms:channelList id="selChannelID" name="content.channelID" value="${content.channelID }"/>	
							</td>			
						</tr>
						<tr>
							<th>内容标题</th>
							<td>
								<input id="txtContentTitle" type="text" name="content.contentTitle" value="${content.contentTitle}">
							</td>
							<th>是否允许评论</th>
							<td>
								<input type="radio" name="content.isAllowComment" value="0" checked="checked">
								<label class="radio_label">不允许</label>
								<input type="radio" name="content.isAllowComment" value="0">
								<label class="radio_label">允许</label>
							</td>
						</tr>
						<tr>							
							<th>内容副标题</th>
							<td>
								<input id="txtContentSubTitle" type="text" name="content.contentSubTitle" value="${content.contentSubTitle}">
							</td>
							<th>meta标题</th>
							<td>
								<input id="txtMetaTitle" type="text" name="content.metaTitle" value="${content.metaTitle}">
							</td>
						</tr>
						<tr>						
							<th>图片标题</th>
							<td>
								<input id="txtImgTitle" type="text" name="content.contentImageTitle" value="${content.contentImageTitle }" />
								<input id="btnImgTitle" type="button" value="选择图片" />
							</td>
							<th>图片预览</th>
							<td><img id="imgTitle" class="img-preview" src="${content.contentImageTitle }"></td>
						</tr>						
						<tr>
							<th>内容摘要</th>
							<td colspan="3">
								<textarea id="txtContentSummary" name="content.contentSummary">${content.contentSummary }</textarea>
							</td>
						</tr>
						<tr>
							<th>内容详细</th>
							<td colspan="3">
							<textarea id="txtContentBody" name="content.contentBody">${content.contentBody }</textarea>
							</td>
						</tr>
						<s:if test="content.contentType == 2">
						<tr>
							<th>产品国家</th>
							<td>
								<core:dictItem name="product.productCountry" id="selProductCountry" dictClassCode="PRODUCT_COUNTRY"/>
							</td>
							<th>产品产地</th>
							<td>
								<core:dictItem name="product.productOrigin" id="selProductOrigin" dictClassCode="PRODUCT_ORIGIN"/>
							</td>
						</tr>
						</s:if>		
						<tr>							
							<th>meta关键字</th>
							<td colspan="3">
								<input id="txtMetaKeywords" type="text" name="content.metaKeywords" value="${content.metaKeywords}">
							</td>
						</tr>
						<tr>
							<th>meta描述</th>
							<td colspan="3">
								<textarea id="txtMetaDescription" name="content.metaDescription">${content.metaDescription }</textarea>
							</td>
						</tr>
						<tr>
							<th>备注</th>
							<td colspan="3">
								<textarea id="txtRemarks" name="content.remarks">${content.remarks }</textarea>
							</td>
						</tr>							
					</table>					
				</form>
				<div class="button_bar">
					<s:if test="content.contentID == null">
						<button type="button" onclick="return createContent();">创建</button>
					</s:if>
					<s:else>
						<button type="button" onclick="return updateContent();">更新</button>
						<button type="button" onclick="btnCopy();">复制</button>
					</s:else>
					<button type="button" onclick="return returnBack();">返回</button>
				</div>			
			</div>
		</div>
	</div>
		
	<jsp:include page="../include/Footer.jsp"></jsp:include>
</body>
</html>