<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="core" uri="/core-tags"%>
<script type="text/javascript">
	function changeDefaultSite() {
		var defaultSite = $("#selDefaultSite").val();
		var url = "updateDefaultSite.action";
		$.getJSON(url, {
			defaultSiteID : defaultSite
		}, function(data) {
			$(location).attr("href", "welcome.action");
		});
	}
</script>
<div class="top_wrap">
	<input id="hidActionURL" type="hidden" value="${actionUrl }">
	<div class="logo_wrap">
		<a href="http://www.iidooo.com" target="_blank"> <img alt="IIDOOO CMS" src="img/Logo_white_8.png">
		</a>
	</div>
	<div class="menu_wrap">
		<div class="login_info">
			<ul>
				<li class="">欢迎：${sessionScope.LOGIN_USER.loginID}</li>
				<li><a href='logout.action'>退出</a></li>
			</ul>
		</div>
		<div class="main_menu_info">
			<core:mainMenu />
			<div class="site_list">
				<label for="selDefaultSite">当前站点：</label>
				<select id="selDefaultSite" name="site.siteID" onChange="changeDefaultSite()">
					<s:iterator value="#session.SESSION_SITE_LIST" id="item" status="st">
						<s:if test="#item.siteID==#session.SESSION_DEFAULT_SITE.siteID">
							<option value="${item.siteID }" selected="selected">${item.siteName }</option>
						</s:if>
						<s:else>
							<option value="${item.siteID }">${item.siteName }</option>
						</s:else>
					</s:iterator>
				</select> &nbsp; <a href="${sessionScope.SESSION_DEFAULT_SITE.siteURL }" target="_blank">查看首页</a>
			</div>
		</div>
	</div>
</div>