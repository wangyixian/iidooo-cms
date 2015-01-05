<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="paging block">
	<input type="button" value="首页" /> 
	<input type="button" value="前一页" /> 
	<span> ${pagingDto.currentPage }/${pagingDto.pageSum }页&nbsp;${pagingDto.recordSum }件
	</span>
	<input type="button" value="后一页"/>
	<input type="button" value="末页"/>	
	&nbsp;&nbsp;第&nbsp;
	<input type="text" />
	&nbsp;页
	<input type="button" value="跳转"/>
	<!-- hidden：本页页面值 -->
	<input type="hidden" name="pagingDto.currentPage" value="${pagingDto.currentPage}">
	<!-- hidden：总页面值 -->
	<input type="hidden" name="pagingDto.pageSum" value="${pagingDto.pageSum}">
	<!-- hidden：总件数 -->
	<input type="hidden" name="pagingDto.recordSum" value="${pagingDto.recordSum}">
	<!-- hidden：画面名 -->
	<input type="hidden" name="actionUrl" value="${actionUrl}">
</div>