<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="f" uri="/framework-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../include/Header.jsp"></jsp:include>
<script type="text/javascript" src="${SITE_URL}/js/lib/KindEditor/kindeditor-min.js"></script>
<script type="text/javascript" src="${SITE_URL}/js/lib/KindEditor/lang/zh_CN.js"></script>
<script type="text/javascript" src="${SITE_URL}/js/lib/jquery.treeview/jquery.treeview.js"></script>
<script type="text/javascript" src="${SITE_URL}/js/lib/jquery.treeview/lib/jquery.cookie.js"></script>
<link type="text/css" rel="stylesheet" href="${SITE_URL}/js/lib/jquery.treeview/jquery.treeview.css">
<link type="text/css" rel="stylesheet" href="${SITE_URL}/css/content/ContentDetail.css">
<script type="text/javascript">
	$(function() {
		$("#tree").treeview({
			animated : "fast",
			persist : "location"
		});
	})
	
	var editor;
	KindEditor.ready(function(K) {
		editor = K.create('textarea[name="content.contentBody"]', {
			allowFileManager : true,
			uploadJson : 'fileUpload.action',
			fileManagerJson : 'kindEditorFileManager.action',
		});
		K('#btnImgTitle').click(function() {
			editor.loadPlugin('image', function() {
				editor.plugin.imageDialog({
					imageUrl : K('#txtImgTitle').val(),
					clickFn : function(url, title, width, height, border, align) {
						K('#txtImgTitle').val(url);
						K('#imgTitle').attr("src",url);
						editor.hideDialog();
					}
				});
			});
		});
	});
	
	function createContent() {
		editor.sync();
		window.form.action = "contentCreate.action";
		window.form.submit();
	}

	function updateContent() {
		editor.sync();
		window.form.action = "contentUpdate.action";
		window.form.submit();
	}

	function deleteContent() {
		editor.sync();
		window.form.action = "contentDelete.action";
		window.form.submit();
	}

	function returnBack() {
		var channelID = $("#hidChannelID").val();
		window.location.href = "contentList.action?channelID=" + channelID;
	}
	
</script>
</head>
<body>
	<form id="form" method="post">
		<jsp:include page="../include/Top.jsp"></jsp:include>
		<div>
			<div class="left_side_wrap">
				<f:tree root="${rootTreeNode}" recursion="true" />	
			</div>
			<div class="right_side_wrap">
				<div class="bread_crumb">
					<span>当前的位置：</span><span>内容管理 - 内容详细</span>
				</div>
				<div>
					<input id="hidChannelID" type="hidden" value="${content.channelID }">
					<input type="hidden" name="content.contentID" value="${content.contentID}">
					<input type="hidden" name="content.contentType" value="${content.contentType }">
					<input type="hidden" name="content.version"	value="${content.version }">
					<table class="grid">
						<tr>							
							<th width="10%">内容类型</th>		
							<td>
								<input type="text" class="width_400px" readonly="readonly" value="${CONTENT_TYPE_MAP[content.contentType]}">
							</td>		
							<th class="required" width="10%">所属栏目</th>
							<td>
								<select name="content.channelID">
									<s:iterator value="allChannels" id="item" status="st">
										<s:if test="content.channelID == #item.channelID">
											<option value="${item.channelID }" selected="selected">${item.channelName }</option>
										</s:if>
										<s:else>
											<option value="${item.channelID }">${item.channelName }</option>
										</s:else>
									</s:iterator>
								</select>
							</td>			
						</tr>
						<tr>
							<th class="required">内容标题</th>
							<td>
								<input class="width_400px" type="text" name="content.contentTitle" value="${content.contentTitle}">
							</td>
							<th class="required">序列</th>
							<td>
								<input type="text" name="content.sequence" value="${content.sequence}">
							</td>
						</tr>
						<tr>							
							<th class="required">内容副标题</th>
							<td>
								<input class="width_400px" type="text" name="content.contentSubTitle" value="${content.contentSubTitle}">
							</td>
							<th class="required">是否允许评论</th>
							<td>
								<input type="radio" name="content.isAllowComment" value="0" checked="checked">不允许
								<input type="radio" name="content.isAllowComment" value="0">允许
							</td>
						</tr>
						<tr>						
							<th>图片标题</th>
							<td>
								<input type="text" id="txtImgTitle" name="content.contentImageTitle" value="${content.contentImageTitle }" />
								<input type="button" id="btnImgTitle" value="选择图片" />
							</td>
							<th>图片预览</th>
							<td><img id="imgTitle" class="img-preview" src="${content.contentImageTitle }"></td>
						</tr>
						<tr>
							<th>meta标题</th>
							<td>
								<input class="width_400px" type="text" name="content.metaTitle"	value="${content.metaTitle}">
							</td>
							<th>meta关键字</th>
							<td>
								<input class="width_400px" type="text" name="content.metaKeywords" value="${content.metaKeywords}">
							</td>
						</tr>
						<tr>
							<th>meta描述</th>
							<td colspan="3">
								<textarea class="width_90per" rows="5" name="content.metaDescription">${content.metaDescription }</textarea>
							</td>
						</tr>
						<tr>
							<th class="required">内容摘要</th>
							<td colspan="3">
								<textarea class="width_90per" rows="5" name="content.contentSummary">${content.contentSummary }</textarea>
							</td>
						</tr>
						<tr>
							<th class="required">内容详细</th>
							<td colspan="3">
							<textarea class="width_90per" id="txtContentBody" name="content.contentBody">${content.contentBody }</textarea>
							</td>
						</tr>
						<tr>
							<th>备注</th>
							<td colspan="3">
								<textarea class="width_90per" rows="5" name="content.remarks">${content.remarks }</textarea>
							</td>
						</tr>
						<s:if test="content.contentType == 2">
						<tr>
							<th>产品分类</th>
							<td>
								<select name="product.productType">
									<s:iterator value="productTypes" id="item" status="st">
										<s:if test="product.productType == #item.dictItemCode">
											<option value="${item.dictItemCode }" selected="selected">${item.dictItemValue }</option>
										</s:if>
										<s:else>
											<option value="${item.dictItemCode }">${item.dictItemValue }</option>
										</s:else>
									</s:iterator>
								</select>
							</td>
							<th>产品国家</th>
							<td>
								<select name="product.productCountry">
									<s:iterator value="productCountries" id="item" status="st">
										<s:if test="product.productCountry == #item.dictItemCode">
											<option value="${item.dictItemCode }" selected="selected">${item.dictItemValue }</option>
										</s:if>
										<s:else>
											<option value="${item.dictItemCode }">${item.dictItemValue }</option>
										</s:else>
									</s:iterator>
								</select>
							</td>
						</tr>
						<tr>						
							<th>产品产地</th>
							<td colspan="3">
								<select name="product.productOrigin">
									<s:iterator value="productOrigins" id="item" status="st">
										<s:if test="product.productOrigin == #item.dictItemCode">
											<option value="${item.dictItemCode }" selected="selected">${item.dictItemValue }</option>
										</s:if>
										<s:else>
											<option value="${item.dictItemCode }">${item.dictItemValue }</option>
										</s:else>
									</s:iterator>
								</select>
							</td>
						</tr>
						</s:if>			
						<s:if test="content.contentType == 3">
						<tr>
							<th>文章类型</th>
							<td colspan="3">
								<select name="article.articleType">
									<s:iterator value="articleTypes" id="item" status="st">
										<s:if test="article.articleType == #item.dictItemCode">
											<option value="${item.dictItemCode }" selected="selected">${item.dictItemValue }</option>
										</s:if>
										<s:else>
											<option value="${item.dictItemCode }">${item.dictItemValue }</option>
										</s:else>
									</s:iterator>
								</select>
							</td>
						</tr>
						</s:if>		
					</table>
					<div class="button_bar">
						<s:if test="content == null || content.contentID == null">
							<input type="button" value="创建" onclick="return createContent();">
						</s:if>
						<s:else>
							<input type="button" value="更新" onclick="return updateContent();">
							<input type="button" value="删除" onclick="return deleteContent();">
						</s:else>
						<input type="button" value="返回" onclick="return returnBack();">
					</div>			
				</div>
			</div>
		</div>
	</form>
</body>
</html>