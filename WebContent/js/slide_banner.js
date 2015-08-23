//左右滚动
(function($) {
	$.fn.extend({
		Scroll : function(opt, callback) {
			if (!opt)
				var opt = {};
			var _btnleft = $(opt.left);
			var _btnright = $(opt.right);
			var timerID;
			var _this = this.eq(0).find("div").eq(1);
			var lineW = _this.find("a:first").width(),
			// 获取列宽
			line = opt.line ? parseInt(opt.line, 10) : parseInt(_this.width()
					/ lineW, 10),
			// 每次滚动的列数，默认为一屏，即父容器列宽
			speed = opt.speed ? parseInt(opt.speed, 10) : 500; // 滚动速度，数值越大，速度越慢（毫秒）
			timer = opt.timer ? parseInt(opt.timer, 10) : 3000; // 滚动的时间间隔（毫秒）
			if (line == 0)
				line = 1;
			var upWidth = 0 - line * lineW;
			// 滚动函数
			var scrollLeft = function() {
				if (!_this.is(":animated")) {
					_this.animate({
						left : upWidth
					}, speed, function() {
						for (i = 1; i <= line; i++) {
							_this.find("a:first").appendTo(_this);
						}
						_this.css({
							left : 0
						});
					});
				}
			}
			var scrollRight = function() {
				if (!_this.is(":animated")) {
					for (i = 1; i <= line; i++) {
						_this.find("a:last").show().prependTo(_this);
					}
					_this.css({
						left : upWidth
					});
					_this.animate({
						left : 0
					}, speed, function() {
					});
				}
			} // Shawphy:自动播放
			var autoPlay = function() {
				if (timer)
					timerID = window.setInterval(scrollLeft, timer);
			};
			var autoStop = function() {
				if (timer)
					window.clearInterval(timerID);
			};
			// 鼠标事件绑定
			_this.hover(autoStop, autoPlay).mouseout();
			_btnleft.css("cursor", "pointer").click(scrollLeft).hover(autoStop,
					autoPlay);
			_btnright.css("cursor", "pointer").click(scrollRight).hover(
					autoStop, autoPlay);
		}
	})
})(jQuery);
$(document).ready(function() {
	$("#scrollable").Scroll({
		line : 5,
		speed : 500,
		timer : 3000,
		left : ".prev",
		right : ".next"
	});
});

// 上下滚动
function AutoScroll(obj) {
	$(obj).find("ul:first").animate({
		marginTop : "-25px"
	}, 500, function() {
		$(this).css({
			marginTop : "0px"
		}).find("li:first").appendTo(this);
	});
}
$(document).ready(function() {
	var myar = setInterval('AutoScroll("#scrollDiv")', 1000);
	$("#scrollDiv").hover(function() {
		clearInterval(myar);
	}, function() {
		myar = setInterval('AutoScroll("#scrollDiv")', 1000)
	}); // 当鼠标放上去的时候，滚动停止，鼠标离开的时候滚动开始
});