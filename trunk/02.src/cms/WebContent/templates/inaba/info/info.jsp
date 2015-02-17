<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="cms" uri="/cms-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="${channel.metaKeywords}" >
<meta name="description" content="${channel.metaDescription}">
<#include "../include/head.html"/>
<link type="text/css" rel="stylesheet" href="${SITE_TEMPLATE_URL}/res/css/channel/info.css">
</head>
<body>
	<#include "../include/top.html"/>
    <div id="news" class="body_wrap">
    	<div class="left_block_wrap">
    		<div class="block">
    			<div class="block_title_21">ç­é¨æç« </div>
    			<div class="block_content">
	    			<ul> 
					<@directiveContentList count='5' channelPath='info' <!-- tagClass='TAG_INFO_CLASSIFY' tagItem='1' --> sortBy='Sequence' sortType="asc">
					<#list returnList as content>
						<li>
							<div class="block_content_item">
								<span><img alt="${content.contentTitle}" src="${CONTENT_RES_ROOT}${content.contentImageTitle}"></span>
								<span class="content_title">${content.contentTitle}</span>
							</div>
						</li>
	 				</#list>
	  				</@directiveContentList>
	  				</ul>
    			</div>
    		</div>
    		<div class="block">
    			<div class="block_title_21">ç­ç¹æ°é»</div>
    			<div class="block_content">
	    			<ul> 
					<@directiveContentList count='5' channelPath='info' <!-- tagClass='TAG_INFO_CLASSIFY' tagItem='2'  -->sortBy='Sequence' sortType="asc">
					<#list returnList as content>
						<li >
							<div class="block_content_item">
								<span class="block_content_item_title">${content.contentTitle}</span>
								<span class="block_content_item_date">${content.updateDate}</span>
							</div>
						</li>
	 				</#list>
	  				</@directiveContentList>
	  				</ul>
    			</div>
    		</div>
    		<div class="block">
    			<div class="block_title_21">è¡èéç¥è¯</div>
    			<div class="block_content">
	    			<ul> 
					<@directiveContentList count='5' channelPath='info' <!-- tagClass='TAG_INFO_CLASSIFY' tagItem='3'  -->sortBy='Sequence' sortType="asc">
					<#list returnList as content>
						<li >
							<div class="block_content_item">
								<span class="block_content_item_title">${content.contentTitle}</span>
								<span class="block_content_item_date">${content.updateDate}</span>
							</div>
						</li>
	 				</#list>
	  				</@directiveContentList>
	  				</ul>
    			</div>
    		</div>
    	</div>
    	<div class="right_block_wrap">
    		<div class="block">
    			<ul> 
				<@directiveContentList count='10' channelPath='article' <!-- tagClass='TAG_INFO_CLASSIFY' tagItem='4' --> sortBy='Sequence' sortType="asc">
				<#list returnList as content>
					<li>
						<#if content_index == 0>
						<div class="top_blog">
							<div class="blog_title">${content.contentTitle}</div>
							<div class="blog_date">${content.updateDate}|${content.contentAuthor}</div>
							<div class="blog_image"><img alt="${content.contentTitle}" src="${CONTENT_RES_ROOT}${content.contentImageTitle}"></div>
							<div class="blog_summary">${content.contentSummary}</div>
						</div>
						<#else>
						<div class="blog">
							<div class="left">
								<div class="blog_title">${content.contentTitle}</div>
								<div class="blog_date">${content.updateDate}|${content.contentAuthor}</div>
								<div class="blog_summary">${content.contentSummary}</div>
							</div>
							<div class="right">							
								<div><img alt="${content.contentTitle}" src="${CONTENT_RES_ROOT}${content.contentImageTitle}"></div>
							</div>
						</div>
						</#if>
					</li>
 				</#list>
  				</@directiveContentList>
  				</ul>
    		</div>
    	</div>
    </div>
    <#include "../include/footer.html"/>
</body>
</html>