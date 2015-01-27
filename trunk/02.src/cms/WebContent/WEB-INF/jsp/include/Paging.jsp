<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">
	function paging(page) {
		var actionName = $("#hidActionName").val();
		var pageSum = $("#hidPageSum").val();
		//alert(actionName);
		//alert(page);
		
		if(page <= 0 || page > pageSum || actionName == ""){
			return;
		}

		// Set the current page then submit to action, do the paging operation.
		$("#hidCurrentPage").val(page);
		
		window.form.action=actionName + ".action";
		window.form.submit();
	}	
	
	function jump(){
		var page = $("#txtJumpPage").val();
		paging(page);
	}
</script>
<div class="paging block align_center">
	<input type="button" value="首页" onclick="paging(1)"/> 
	<input type="button" value="前一页" onclick="paging(${pagingDto.currentPage - 1})"/> 
	<span> ${pagingDto.currentPage }/${pagingDto.pageSum }页&nbsp;${pagingDto.recordSum }件
	</span>
	<input type="button" value="后一页" onclick="paging(${pagingDto.currentPage + 1})"/>
	<input type="button" value="末页" onclick="paging(${pagingDto.pageSum})"/>	
	&nbsp;&nbsp;第&nbsp;
	<input id="txtJumpPage" type="text" class="width_20"/>
	&nbsp;页
	<input type="button" value="跳转" onclick="jump()"/>

	<input id="hidCurrentPage" type="hidden" name="pagingDto.currentPage">
	<input id="hidActionName" type="hidden" value="${actionName }">
	<input id="hidPageSum" type="hidden" value="${pagingDto.pageSum}">
</div>