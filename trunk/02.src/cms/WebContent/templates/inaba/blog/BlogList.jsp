<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="cms" uri="/cms-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="${channel.metaKeywords}" >
<meta name="description" content="${channel.metaDescription}">
<jsp:include page="../include/Head.jsp"></jsp:include>
<link type="text/css" rel="stylesheet" href="${SITE_TEMPLATE_URL}/res/css/blog/BlogList.css">
</head>
<body>
	<form id="form" action="" method="post">
		<input id="hidChannelID" type="hidden" name="channel.channelID" value="${channel.channelID }">
		<jsp:include page="../include/Top.jsp"></jsp:include>
	    <div id="news" class="body_wrap">
	    	<cms:mainmenu channelPath="blogList" />
	    	<div class="left_block_wrap">
	    		<cms:articles blockTitle="热门文章" articleType="1" channelID="${channel.channelID }"/>
	    		<cms:articles blockTitle="热点新闻" articleType="2" channelID="${channel.channelID }"/>
	    		<cms:articles blockTitle="葡萄酒知识" articleType="3" channelID="${channel.channelID }"/>
	    	</div>
	    	<div class="right_block_wrap">
	    		<div class="block">
	    			<ul> 
					<s:iterator value="articles" id="item" status="st">
						<li>
							<s:if test="#st.first">
							<div class="top_blog">
								<div class="blog_title">
									<a href="articleDetail.action?content.contentID=${item.contentID }" target='_blank'>${item.contentTitle}</a>
								</div>
								<div class="blog_date">${item.updateDate}|${item.createUserName}</div>
								<div class="blog_image">
									<a href="articleDetail.action?content.contentID=${item.contentID }" target='_blank'>
									<img alt="${item.contentTitle}" src="${CONTENT_RES_ROOT}${item.contentImageTitle}">
									</a>
								</div>
								<div class="blog_summary">${item.contentSummary}</div>
							</div>
							</s:if>
							<s:else>
							<div class="blog">
								<div class="left">
									<div class="blog_title">
										<a href="articleDetail.action?content.contentID=${item.contentID }" target='_blank'>${item.contentTitle}</a>
									</div>
									<div class="blog_date">${item.updateDate}|${item.createUserName}</div>
									<div class="blog_summary">${item.contentSummary}</div>
								</div>
								<div class="right">							
									<div>
										<a href="articleDetail.action?content.contentID=${item.contentID }">
										<img alt="${item.contentTitle}" src="${CONTENT_RES_ROOT}${item.contentImageTitle}">
										</a>
									</div>
								</div>
							</div>
							</s:else>
						</li>
	 				</s:iterator>
	  				</ul>
	    		</div>
	    		<jsp:include page="../include/Paging.jsp"></jsp:include>
	    	</div>
	    </div>
	   <jsp:include page="../include/Footer.jsp"></jsp:include>	
   </form>
</body>
</html>