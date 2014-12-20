function changeTab(sum, cur) {
	$allTabs = $("#tabs .tabs li");
	$allContents = $("#tabs .contents>div");

	var i = 0;
	$allTabs.each(function() {
		$(this).removeClass("current");
		if (i == cur) {
			$(this).addClass("current");
		}
		i++;
	});

	i = 0;
	$allContents.each(function() {
		$(this).addClass("hidden");
		if (i == cur) {
			$(this).removeClass("hidden");
		}
		i++;
	});
}