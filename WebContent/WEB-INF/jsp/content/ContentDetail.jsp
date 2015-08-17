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
<jsp:include page="../include/KindEditor.jsp"></jsp:include>

<script type="text/javascript" src="js/content/ContentDetail.js"></script>
<link type="text/css" rel="stylesheet" href="css/content/ContentDetail.css">

<script type="text/javascript">

	function createContent() {
		editor.sync();
		
		var $form = $("form");
		$form.attr("action","contentCreate.action");
		//if (validate()) {
		$form.submit();
		//}
	}

	function updateContent() {
		editor.sync();
		
		var $form = $("form");
		$form.attr("action","contentUpdate.action");
		//if(validate()){
		$form.submit();
		//}
	}

	function btnCopy() {
		editor.sync();
		$("#hidMode").val(3);
		
		var $form = $("form");
		$form.attr("action","contentDetail.action");
		$form.submit();
	}

	function deleteContent() {
		editor.sync();
		
		var $form = $("form");
		$form.attr("action","contentDelete.action");
		$form.submit();
	}

	function returnBack() {
		var siteID = $("#hidSiteID").val();
		var channelID = $("#hidChannelID").val();
		$(location).attr('href',"contentList.action?content.siteID=" + siteID	+ "&content.channelID=" + channelID);
	}

	function validate() {
		var message = "";
		var txtContentTitle = $("#txtContentTitle").val();
		if (txtContentTitle == "") {
			message += "内容标题不能为空。";
		}
		if (message != "") {
			alert(message);
			return false;
		}
		return true;
	}
</script>

</head>
<body>	
	<jsp:include page="../include/Top.jsp"></jsp:include>		
	<div class="page_content_wrap">	
		<div class="page_content_left_wrap">
			<cms:channelTree baseURL="contentList.action?content.channelID={0}" title="栏目树"/>			
		</div>
		<div class="page_content_right_wrap">		
			<passport:breadCrumb/>	
			<div class="page_content">
				<s:actionerror/>
				<s:actionmessage/>
				<form id="form" method="post">					
					<input id="hidChannelID" type="hidden" name="content.channelID" value="${content.channelID }">
					<input type="hidden" name="content.contentID" value="${content.contentID}">
					<input type="hidden" name="content.contentType" value="${content.contentType }">
					<input type="hidden" name="content.version"	value="${content.version }">		
					<table class="datagrid">
						<tr>							
							<th width="10%">内容类型</th>		
							<td>
								<core:dictItemSelect id="selContentType" name="content.contentType" dictClassCode="DICT_CLASS_CONTENT_TYPE" value="${content.contentType }" isDiabled="true"/>	
							</td>		
							<th width="10%">所属栏目</th>
							<td>
								<cms:channelSelect id="selChannelID" name="content.newChannelID" value="${content.channelID }" isContainBlank="false"/>	
							</td>			
						</tr>
						<tr>
							<th>内容标题</th>
							<td>
								<input id="txtContentTitle" type="text" name="content.contentTitle" value="${content.contentTitle}">
							</td>
							<th>是否允许评论</th>
							<td>
								<input type="radio" name="content.isSilent" value="0" checked="checked">
								<label class="radio_label">不允许</label>
								<input type="radio" name="content.isSilent" value="1">
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
								<textarea id="txtContentBody" class="kind_editor" name="content.contentBody">${content.contentBody }</textarea>
							</td>
						</tr>
						<s:if test="content.contentType == 2">
						<tr>
							<th>产品国家</th>
							<td>
								<core:dictItemSelect name="product.productCountry" id="selProductCountry" dictClassCode="DICT_CLASS_INABA_COUNTRY"/>
							</td>
							<th>产品产地</th>
							<td>
								<core:dictItemSelect name="product.productOrigin" id="selProductOrigin" dictClassCode="DICT_CLASS_INABA_ORIGIN"/>
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
						<!-- <button type="button" onclick="btnCopy();">复制</button> -->
					</s:else>
					<button type="button" onclick="return returnBack();">返回</button>
				</div>			
			</div>
		</div>
	</div>
</body>
</html>