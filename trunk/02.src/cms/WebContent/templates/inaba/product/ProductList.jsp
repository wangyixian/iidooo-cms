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
<link type="text/css" rel="stylesheet" href="${SITE_TEMPLATE_URL}/res/css/product/ProductList.css">
<script type="text/javascript">
	function searchByCountry(productCountry){
		$("#hidProductCountry").val(productCountry);
		window.form.submit();
	}
	
	function searchByOrigin(productOrigin){
		$("#hidProductOrigin").val(productOrigin);
		window.form.submit();
	}
	
	function searchByType(productType){
		$("#hidProductType").val(productType);
		window.form.submit();
	}
</script>
</head>
<body>
	<form id="form" action="productList" method="post">
		<input id="hidProductCountry" type="hidden" name="product.productCountry" value="${product.productCountry }">
	    <input id="hidProductOrigin" type="hidden" name="product.productOrigin" value="${product.productOrigin }">
	    <input id="hidProductType" type="hidden" name="product.productType" value="${product.productType }">
	    <input type="hidden" name="channel.channelID" value="${channel.channelID }">
	    
		<jsp:include page="../include/Top.jsp"></jsp:include>
	    <div class="body_wrap">	    	
	    	<cms:mainmenu channelPath="productList" />
	    	<div id="classify" class="block frame">
		    	<dl>
		    		<dt>国家：</dt>
		    		<dd>
		    			<div>
		    			<s:if test="product.productCountry <= 0">	    			
		    				<a href="#" class="focus" onclick="searchByCountry(0)">全部</a>
		    			</s:if>
		    			<s:else>
		    				<a href="#" onclick="searchByCountry(0)">全部</a>	    			
		    			</s:else>
		    			<s:iterator value="productCountries" status="st" id="item">	
			    			<s:if test="product.productCountry == #item.dictItemCode">	       			
				    			<a href="#" class="focus" onclick="searchByCountry(${item.dictItemCode})">${item.dictItemName}</a>
				    		</s:if>
				    		<s:else>
				    			<a href="#" onclick="searchByCountry(${item.dictItemCode})">${item.dictItemName}</a>
				    		</s:else>
		    			</s:iterator>
		    			</div>
		    		</dd>
		    	</dl>	
		    	<dl>
		    		<dt>产地：</dt>
		    		<dd>
		    			<div>
		    			<s:if test="product.productOrigin <= 0">	    			
		    				<a href="#" class="focus" onclick="searchByOrigin(0)">全部</a>
		    			</s:if>
		    			<s:else>
		    				<a href="#" onclick="searchByOrigin(0)">全部</a>
		    			</s:else>
		    			<s:iterator value="productOrigins" status="st" id="item">	
			    			<s:if test="product.productOrigin == #item.dictItemCode">	       			
				    			<a href="#" class="focus" onclick="searchByOrigin(${item.dictItemCode})">${item.dictItemName}</a>
				    		</s:if>
		    				<s:else>
				    			<a href="#" onclick="searchByOrigin(${item.dictItemCode})">${item.dictItemName}</a>
				    		</s:else>
		    			</s:iterator>
		    			</div>
		    		</dd>
		    	</dl>	
		    	<dl>
		    		<dt>分类：</dt>
		    		<dd>
		    			<div>
		    			<s:if test="product.productType<= 0">	    			
		    				<a href="#" class="focus" onclick="searchByType(0)">全部</a>
		    			</s:if>
		    			<s:else>
		    				<a href="#" onclick="searchByType(0)">全部</a>
		    			</s:else>
		    			<s:iterator value="productTypes" status="st" id="item">	
			    			<s:if test="product.productType == #item.dictItemCode">	       			
				    			<a href="#" class="focus" onclick="searchByType(${item.dictItemCode})">${item.dictItemName}</a>
				    		</s:if>
		    				<s:else>
				    			<a href="#" onclick="searchByType(${item.dictItemCode})">${item.dictItemName}</a>
				    		</s:else>
		    			</s:iterator>
		    			</div>
		    		</dd>
		    	</dl>    	
	    	</div>
			<div id="products" class="block">
				<ul>
					<s:iterator value="products" status="st" id="item">	
					<li class="left">
						<div>
							<a href="productDetail.action?content.contentID=${item.contentID }" target="_blank"><img alt="${item.contentTitle}" src="${item.contentImageTitle}"></a>
						</div>
						<div class="align_center">
							<a href="productDetail.action?content.contentID=${item.contentID }" target="_blank">${item.contentTitle}</a>
						</div>
					</li>
					</s:iterator>
				</ul>
			</div>
			<jsp:include page="../include/Paging.jsp"></jsp:include>
		</div>
	    <jsp:include page="../include/Footer.jsp"></jsp:include>
    </form>
</body>
</html>