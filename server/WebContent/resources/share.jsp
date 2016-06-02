<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="maximum-scale=1.0, minimum-scale=1.0, user-scalable=0, initial-scale=1.0, width=device-width" />
<meta name="format-detection" content="telephone=no, email=no, date=no, address=no">
<title>毒电波</title>
<link rel="shortcut icon" href="http://iidooo-toxic-wave.oss-cn-shanghai.aliyuncs.com/resources/img/favicon.ico" />
<link rel="bookmark" href="http://iidooo-toxic-wave.oss-cn-shanghai.aliyuncs.com/resources/img/favicon.ico" />
<link rel="stylesheet" type="text/css" href="http://iidooo-toxic-wave.oss-cn-shanghai.aliyuncs.com/resources/css/api.css" />
<script type="text/javascript" src="http://iidooo-toxic-wave.oss-cn-shanghai.aliyuncs.com/resources/js/libs/showdown/showdown.min.js"></script>
<script type="text/javascript" src="http://iidooo-toxic-wave.oss-cn-shanghai.aliyuncs.com/resources/js/libs/jquery/jquery-2.1.4.min.js"></script>
<link rel="stylesheet" type="text/css" href="http://iidooo-toxic-wave.oss-cn-shanghai.aliyuncs.com/resources/js/libs/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript" src="http://iidooo-toxic-wave.oss-cn-shanghai.aliyuncs.com/resources/js/libs/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>

<style type="text/css">

#page{
	max-width: 980px;
}

.content hr {
	border: 0px;
	border-top: 1px solid rgba(220, 220, 220, 1.0);
}

.content {
	margin-bottom: 40px;
}
</style>
</head>
<body>
	<div id="page">
		<input id="appID" type="hidden" value="${appID }"> <input id="timestamp" type="hidden" value="${signature.timestamp }"> <input
			id="nonceStr" type="hidden" value="${signature.nonceStr }"> <input id="signature" type="hidden" value="${signature.signature }"> <input
			id="url" type="hidden" value="${signature.url }"> <input id="imageTitle" type="hidden" value="${content.contentImageTitle }"> <input
			id="subTitle" type="hidden" value="${content.contentSubTitle }"> <input id="summary" type="hidden" value="${content.contentSummary }">
		<input id="createUserName" type="hidden" value="${content.createUser.userName }"> <input id="hidSource" type="hidden" value="${source }">

		<div class="area1">
			<div id="title" class="title">${content.contentTitle}</div>
			<div>
				来源：<span id="source"></span>
			</div>
			<div id="insert" class="content">${content.contentBody}</div>
		</div>
		<a id="download" class="area2" href="http://a.app.qq.com/o/simple.jsp?pkgname=com.cookie.toxicwave"> <img id="logo"
			src="http://iidooo-toxic-wave.oss-cn-shanghai.aliyuncs.com/resources/img/logo-small.png"> <span>点我下载毒电波APP-有毒的负能量平台</span>
		</a>
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-body">
				<img style='width: 70%; float: right;' src="http://iidooo-toxic-wave.oss-cn-shanghai.aliyuncs.com/resources/img/img_share.png">
			</div>
		</div>
	</div>
</body>
<script>
	showdown.setOption('strikethrough', 'true');
	var converter = new showdown.Converter();
	var text = document.getElementById("insert").innerHTML
			.replace(/&gt;/g, ">");
	var html = converter.makeHtml(text);
	document.getElementById("insert").innerHTML = html;

	/* function checkDownload() {
		var ua = navigator.userAgent.toLowerCase();
		if (ua.match(/MicroMessenger/i) == "micromessenger" || 
				ua.match(/WeiBo/i) == "weibo") {
			$('#myModal').modal('show')
		} else {
			if (/iphone|ipad|ipod/.test(ua)) {
				location.href = "https://itunes.apple.com/cn/app/id1102004240?ls=1&mt=12";
			} else if (/android/.test(ua)) {
				location.href = "http://a.app.qq.com/o/simple.jsp?pkgname=com.cookie.toxicwave";
			}
		}
	} */

	wx.config({
		debug : false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
		appId : $("#appID").val(), // 必填，企业号的唯一标识，此处填写企业号corpid
		timestamp : $("#timestamp").val(), // 必填，生成签名的时间戳
		nonceStr : $("#nonceStr").val(), // 必填，生成签名的随机串
		signature : $("#signature").val(),// 必填，签名，见附录1
		jsApiList : [ 'onMenuShareTimeline', 'onMenuShareAppMessage',
				'onMenuShareQQ', 'onMenuShareWeibo' ]
	// 必填，需要使用的JS接口列表，所有JS接口列表见附录2
	});

	wx
			.ready(function() {
				var titleToFriend = $("#title").text();
				if (titleToFriend == "") {
					titleToFriend = "有毒的负能量平台";
				}

				var contentBody = $("#insert").text();
				/* contentBody = contentBody.replace(/[\r\n]/g,"");//去掉回车换行
				contentBody = contentBody.replace("![]","");
				contentBody = contentBody.substring(0,50); */
				var titleToTimeline = $("#title").text()
				if (titleToTimeline == "") {
					titleToTimeline = contentBody;
				}

				var imgUrl = 'http://iidooo-toxic-wave.oss-cn-shanghai.aliyuncs.com/resources/img/logo-small.png';
				var imgTitle = $("#imageTitle").val();
				if (imgTitle != "") {
					imgUrl = imgTitle;
				}

				var desc = $("#subTitle").val();
				if (desc == "") {
					desc = $("#summary").val();
					if (desc == "") {
						desc = contentBody;
					}
				}

				// 获取“分享到朋友圈”按钮点击状态及自定义分享内容接口
				wx.onMenuShareTimeline({
					title : titleToTimeline, // 分享标题
					link : $("#url").val(), // 分享链接
					imgUrl : imgUrl, // 分享图标
					success : function() {
						// 用户确认分享后执行的回调函数
					},
					cancel : function() {
						// 用户取消分享后执行的回调函数
					}
				});

				// 获取“分享给朋友”按钮点击状态及自定义分享内容接口
				wx.onMenuShareAppMessage({
					title : titleToFriend, // 分享标题
					desc : desc, // 分享描述
					link : $("#url").val(), // 分享链接
					imgUrl : imgUrl, // 分享图标
					type : '', // 分享类型,music、video或link，不填默认为link
					dataUrl : '', // 如果type是music或video，则要提供数据链接，默认为空
					success : function() {
						// 用户确认分享后执行的回调函数
					},
					cancel : function() {
						// 用户取消分享后执行的回调函数
					}
				});

				//获取“分享到QQ”按钮点击状态及自定义分享内容接口
				wx.onMenuShareQQ({
					title : titleToFriend, // 分享标题
					desc : desc, // 分享描述
					link : $("#url").val(), // 分享链接
					imgUrl : imgUrl, // 分享图标
					success : function() {
						// 用户确认分享后执行的回调函数
					},
					cancel : function() {
						// 用户取消分享后执行的回调函数
					}
				});

				//获取“分享到腾讯微博”按钮点击状态及自定义分享内容接口
				wx.onMenuShareWeibo({
					title : titleToFriend, // 分享标题
					desc : desc, // 分享描述
					link : $("#url").val(), // 分享链接
					imgUrl : imgUrl, // 分享图标
					success : function() {
						// 用户确认分享后执行的回调函数
					},
					cancel : function() {
						// 用户取消分享后执行的回调函数
					}
				});
			});

	var source = $("#hidSource").val();
	if (source != null && source != "") {
		$("#source").text(source);
	} else {
		$("#source").text($("#createUserName").val());
	}
</script>
</html>