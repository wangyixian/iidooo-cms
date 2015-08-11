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
				<li class="">欢迎：${sessionScope.LOGIN_USER.userName}</li>
				<li><a href='logout.action'>退出</a></li>
			</ul>
		</div>	
		<div class="main_menu_info">			
			<passport:mainMenu/>
			<div class="site_list">
				<label for="selDefaultSite">当前站点：</label>
				<select id="selDefaultSite" name="site.siteID">
					<s:iterator value="#session.LOGIN_SITE_LIST" id="item" status="st">
					<s:if test="#item.siteID==site.siteID">
						<option value="${item.siteID }" selected="selected">${item.siteName }</option>
					</s:if>
					<s:else>
						<option value="${item.siteID }">${item.siteName }</option>
					</s:else>
					</s:iterator>
				</select>
				<a href="${site.siteURL }">查看首页</a>
			</div>			
		</div>		
	</div>
</div>