$(function(){
	
	// 图片上下翻滚
	var len = $('.slidebtn>ul>li').length;
	var index = 0;
	var autoplay;
	$('.slidebtn li').mouseover(function(){
		index = $('.slidebtn li').index(this);
		showImg(index);
	}).eq(0).mouseover();
	
	$('.slidebox').hover(function(){
		clearInterval(autoplay);
	},function(){
		autoplay = setInterval(function(){
			showImg(index)
			index++;
			if(index==len){
				index=0;
			}
		},3000);
	}).trigger('mouseleave');

	function showImg(index){
		var picheight = $('.slidebox').height();
		$('.slidepic').stop(true,false).animate({top:-picheight*index},600)
		$('.slidebtn li').removeClass('current').eq(index).addClass('current');
	};
	
	
	// 图片左右翻滚
	var size = $('.slidebtn-01>ul>li').length;
	var frist = 0;
	var datetime;
	$('.slidebtn-01 li').mouseover(function(){
		frist = $('.slidebtn-01 li').index(this);
		showpic(frist);
	}).eq(0).mouseover();
	
	$('.slidebox-01').hover(function(){
		clearInterval(datetime);
	},function(){
		datetime = setInterval(function(){
			showpic(frist)
			frist++;
			if(frist==size){
				frist=0;
			}
		},3000);
	}).trigger('mouseleave');

	function showpic(frist){
		var imgheight = $('.slidebox-01').width();
		$('.slidepic-01').stop(true,false).animate({left:-imgheight*frist},600)
		$('.slidebtn-01 li').removeClass('current').eq(frist).addClass('current');
	};
	
});

//图片淡隐淡现
var defaultOpts ={ interval:2000, fadeInTime:300, fadeOutTime:200 };

	var _titles = $("ul.slide-txt li");
	var _titles_bg = $("ul.op li");
	var _bodies = $("ul.slide-pic li");
	var _count = _titles.length;
	var _current = 0;
	var _intervalID = null;
	
	var stop = function(){
		window.clearInterval(_intervalID);
	};
	
	var slide = function(opts){
		if (opts){
			_current = opts.current || 0;
		} else{
			_current = (_current >= (_count - 1)) ? 0 :(++_current);
		};
		_bodies.filter(":visible").fadeOut(defaultOpts.fadeOutTime, function(){
			_bodies.eq(_current).fadeIn(defaultOpts.fadeInTime);
			_bodies.removeClass("current").eq(_current).addClass("current");
		});
		_titles.removeClass("current").eq(_current).addClass("current");
		_titles_bg.removeClass("current").eq(_current).addClass("current");
	}; 
	
	var go = function(){
		stop();
		_intervalID = window.setInterval(function(){
			slide();
		}, defaultOpts.interval);
	}; 
	
	var itemMouseOver = function(target, items){
		stop();
		var i = $.inArray(target, items);
		slide({ current:i });
	};
	
	_titles.hover(function(){
		if($(this).attr('class')!='current'){
			itemMouseOver(this, _titles);
		}else{
			stop();
		}
	}, go);

	_bodies.hover(stop, go);

	go();