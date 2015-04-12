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
	<button type="button" value="首页" onclick="paging(1)">首页</button>
	<button type="button" value="前一页" onclick="paging(${pagingDto.currentPage - 1})">前一页</button>
	<span> ${pagingDto.currentPage }/${pagingDto.pageSum }页&nbsp;${pagingDto.recordSum }件
	</span>
	<button type="button" value="后一页" onclick="paging(${pagingDto.currentPage + 1})">后一页</button>
	<button type="button" value="末页" onclick="paging(${pagingDto.pageSum})">末页</button>
	&nbsp;&nbsp;第&nbsp;
	<input id="txtJumpPage" type="text" class="width_20"/></input>
	&nbsp;页
	<button type="button" value="跳转" onclick="jump()"/>跳转</button>

	<input id="hidCurrentPage" type="hidden" name="pagingDto.currentPage" value="${pagingDto.currentPage}">
	<input id="hidActionName" type="hidden" value="${actionName }">
	<input id="hidPageSum" type="hidden" value="${pagingDto.pageSum}">
</div>