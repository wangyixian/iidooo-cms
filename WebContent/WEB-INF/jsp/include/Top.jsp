<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="passport" uri="/passport-tags"%>
<div class="top_wrap">
	<div class="logo_wrap">
		<a href="http://www.iidooo.com" target="_blank"> <img alt="IIDOOO CMS" src="img/Logo_white_8.png">
		</a>
	</div>
	<div class="menu_wrap">
		<div class="login_info">
			<ul>
				<li><a href='logout.action'>退出</a></li>
				<li class="">欢迎：${USER_NAME }</li>
			</ul>
		</div>
		<passport:mainMenu/>
	</div>
</div>