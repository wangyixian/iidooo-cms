/*
功能：Jquery无缝滚动插件zhw.scroll-1.0.js
作者：leo
注意：暂只支持div下ul li的滚动
交流：xandchd_kane@163.com
*/
jQuery.extend({
    Scroll: function(settings) {
        //初始化参数
        var config = $.extend({
            stepWidth: 100,         // 滚动步长
            waitTime: 4000,         // 间歇时间
            animateTime: 500,       // 滚动效果时间,理论上应该比间歇时间短
            inner: "",              // 滚动对象
            left: "",               // 左点击对象
            right: ""               // 右点击对象
        }, settings);
        var flag = setInterval(AutoScroll, parseInt(config.waitTime));
        //左滚
        $(config.left).click(function() { AutoScroll(); });
        //右滚
        $(config.right).click(function() { RightScroll(); });
        //悬停
        $("" + config.left + "," + config.right + "," + config.inner + "").hover(function() { clearInterval(flag) }, function() {
            flag = setInterval(AutoScroll, parseInt(config.waitTime));
        });
        function AutoScroll() {
            var marginLeft = $(config.inner).css("margin-left");
            $(config.inner).stop().animate({ "margin-left": parseInt(marginLeft) - config.stepWidth }, config.animateTime, function() {
                var n = $("li").toArray(); //转换为对象数组
                var k = $.grep(n, function(i, j) { return j > 0; }); //筛选
                var temp = $.grep(n, function(i, j) { return j > 0; }, true); //筛选
                $(config.inner).children("ul").html(""); //清空
                $(k).each(function(i, j) {
                    $(config.inner).children("ul").append(j); //重新拼装内容
                });
                $(config.inner).children("ul").append(temp); //拼装被筛选出去的对象
                $(config.inner).css("margin-left", 0); //初始化marginleft
            });
        }
        function RightScroll() {
            //向右需要先拼装再移动
            var marginLeft = $(config.inner).css("margin-left");
            var n = $("li").toArray(); //转换为对象数组
            var k = $.grep(n, function(i, j) { return j < n.length - 1; }); //筛选
            var temp = $.grep(n, function(i, j) { return j > n.length - 1; }, true); //筛选
            $(config.inner).children("ul").html("").append(temp); //拼装被筛选出去的对象
            $(k).each(function(i, j) {
                $(config.inner).children("ul").append(j); //重新拼装内容
            });
            $(config.inner).css("margin-left", -config.stepWidth);
            //
            $(config.inner).stop().animate({ "margin-left": parseInt(marginLeft) }, config.animateTime);
        }
    }
});