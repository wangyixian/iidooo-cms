<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="cms" uri="/cms-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="${channel.metaKeywords}" >
<meta name="description" content="${channel.metaDescription}">
<jsp:include page="../include/Head.jsp"></jsp:include>
<link type="text/css" rel="stylesheet" href="${SITE_TEMPLATE_URL}/res/css/index/Index.css">
</head>
<body>
	<jsp:include page="../include/Top.jsp"></jsp:include>
	<div id="index" class="body_wrap">	
		<cms:mainmenu channelPath="index" />
    	<div id="banner" class="banner"><img src="${SITE_TEMPLATE_URL}/res/img/index/banner.png"></div>
    	<div>
			<div class="left_block_wrap">
				<div id="nominate" class="block">
					<div class="block_title">
						<a class="main_title">精品展示</a>
					</div>
					<div id="slide" class="block_content">
						<ul class="slideul1"> 
							<li class="slideli1"> 								
		    					<ul class="slideul2">
									<cms:contentList channelPath="nominate" action='productDetail' isShowImage="true"/>
		    					</ul>
    						</li>
    						<li class="slideli2"></li> 
    					</ul>
					</div>
				</div>
			</div>
			<div class="right_block_wrap">
				<div id="info" class="block">
					<div class="block_title">
						<a class="main_title">最新资讯</a>
					</div>
					<div class="block_content">					
    					<ul>
    						<cms:contentList channelPath='blogList' action='articleDetail' isShowDate='true' sortField='UpdateTime' sortType='desc' pageStart='0' pageSize='10'/>
    					</ul>
					</div>
				</div>				
			</div>
		</div>
		<div>
    		<div>
    			<div id="sales" class="block">
    				<div class="block_title">
    					<a class="main_title">
    						热销红酒
    						<span class="mark_top"></span>
    						<span class="mark_bottom"></span>
    					</a>
    				</div>
    				<div class="block_content">
    					<ul class="product_list">
							<cms:contentList channelPath="sales" action='productDetail' isShowImage="true" pageStart='0' pageSize='8' />
    					</ul>
    				</div>
    			</div>
    		</div>
    	</div>
    </div>
    <jsp:include page="../include/Footer.jsp"></jsp:include>
</body>

<script type="text/javascript" src="${SITE_TEMPLATE_URL}/res/js/scroll.js"></script>
</html>