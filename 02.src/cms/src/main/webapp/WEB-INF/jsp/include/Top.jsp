<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div id="top_wrap">
	<div id="logo">
		<a href="www.iidooo.com" target="_blank"> <img alt="IDO CMS" src="${SITE_URL}/image/Logo_white_8.png">
		</a>
	</div>
	<div id="menu_wrap">
		<div id="login_info"></div>
		<div id="menu">
			<ul>
				<li><a href="index.action" <s:if test='actionName=="index"'>class="focus"</s:if>>首页</a></li>
				<li><a href="channelList.action" <s:if test='actionName=="channelList"'>class="focus"</s:if>>栏目</a></li>
				<li><a href="contentList.action" <s:if test='actionName=="contentList"'>class="focus"</s:if>>内容</a></li>
			</ul>
		</div>
	</div>
</div>