<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">
	function paging(page) {
		var actionName = $("#hidActionName").val();
		var pageSum = $("#hidPageSum").val();
		//alert(actionName);
		//alert(page);
		
		// Because paging is form post，the action url could not contain any parameters.
		if(page <= 0 || page > pageSum || actionName == ""){
			return;
		}

		// Set the current page then submit to action, do the paging operation.
		$("#hidCurrentPage").val(page);
		
		var $form = $("form");
		$form.attr("action",actionName+".action");
		$form.submit();		
	}	
	
	function jump(){
		var page = $("#txtJumpPage").val();
		paging(page);
	}
</script>
<div class="paging block align_center">
	<button type="button" value="首页" onclick="paging(1)">首页</button>
	<button type="button" value="前一页" onclick="paging(${page.currentPage - 1})">前一页</button>
	<span> ${page.currentPage }/${page.pageSum }页&nbsp;${page.recordSum }件
	</span>
	<button type="button" value="后一页" onclick="paging(${page.currentPage + 1})">后一页</button>
	<button type="button" value="末页" onclick="paging(${page.pageSum})">末页</button>
	&nbsp;&nbsp;第&nbsp;
	<input id="txtJumpPage" type="text"/>
	&nbsp;页
	<button type="button" value="跳转" onclick="jump()">跳转</button>

	<input id="hidCurrentPage" type="hidden" name="page.currentPage" value="${page.currentPage}">
	<input id="hidPageSize" type="hidden" name="page.pageSize" value="${page.pageSize}">
	<input id="hidActionName" type="hidden" value="${actionName }">
	<input id="hidPageSum" type="hidden" value="${page.pageSum}">
</div>