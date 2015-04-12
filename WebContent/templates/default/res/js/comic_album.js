$(document).ready(function() {
	// Set the default caricature page
	var selectPage = document.getElementById("selectPage1");
	var index = selectPage.selectedIndex;
	var $currentPage = $("#currentPage");
	var $nextPage = $("#nextPage");
	var $previousPage = $("#previousPage");
	if (index >= 0) {
		var currentURL = selectPage.options[index].value;
		$currentPage.attr("src", currentURL);

		if (selectPage.options.length > index + 1) {
			var nextURL = selectPage.options[index + 1].value;
			$nextPage.attr("src", nextURL);
		}
	}
	$nextPage.hide();
	$previousPage.hide();

	// key down change the page
	$(document).keydown(function(e) {
		var code;
		if (!e)
			var e = window.event;
		if (e.keyCode) {
			code = e.keyCode;
		} else if (e.which) {
			code = e.which;
		}

		if (code == 37) {
			// previous
			changeSelected(true);
		} else if (code == 39) {
			// next
			changeSelected(false);
		} else if (code == 90) {
			// key z/Z
			var href = $("#preAlbum").attr("href");
			window.location.href = href;
		} else if (code == 88) {
			// key x/X
			var href = $("#nextAlbum").attr("href");
			window.location.href = href;
		}
	});
});

function changeSelected(isup) {
	var selectPage1 = document.getElementById("selectPage1");
	var selectPage2 = document.getElementById("selectPage2");
	var index = selectPage1.selectedIndex;
	if (isup) {
		if(index == 0){
			alert("已经是第一页了！");
			return;
		}
		
		if (index > 0) {
			index = index - 1;
			var $currentPage = $("#currentPage");
			$currentPage.hide();
			// Previous page show
			var $previousPage = $("#previousPage");
			$previousPage.show();
			var $nextPage = $("#nextPage");
			// reset the id
			$previousPage.attr("id", "currentPage");
			$currentPage.attr("id", "nextPage");
			$nextPage.attr("id", "previousPage");

			var $previousPage = $("#previousPage");
			if (index > 0) {
				var previousURL = selectPage1.options[index - 1].value;
				$previousPage.attr("src", previousURL);
			} else {
				$previousPage.attr("src", "");
			}
		}
	} else {
		if(index + 1 == selectPage1.options.length){
			alert("已经是最后一页了！");
			return;
		}
		if (index + 1 < selectPage1.options.length) {
			index = index + 1;
			var $currentPage = $("#currentPage");
			$currentPage.hide();
			// Next page show
			var $nextPage = $("#nextPage");
			$nextPage.show();
			var $previousPage = $("#previousPage");

			// reset the id
			$nextPage.attr("id", "currentPage");
			$currentPage.attr("id", "previousPage");
			$previousPage.attr("id", "nextPage");

			var $nextPage = $("#nextPage");
			if (index + 1 < selectPage1.options.length) {
				var nextURL = selectPage1.options[index + 1].value;
				$nextPage.attr("src", nextURL);
			} else {
				$nextPage.attr("src", "");
			}
		}
	}
	selectPage1.options[index].selected = true;
	selectPage2.options[index].selected = true;
}

function changePage(selectObject) {
	var selectPage1 = document.getElementById("selectPage1");
	var selectPage2 = document.getElementById("selectPage2");
	var index;
	if (selectObject == 1) {
		index = selectPage1.selectedIndex;
		selectPage2.options[index].selected = true;
	} else {
		index = selectPage2.selectedIndex;
		selectPage1.options[index].selected = true;
	}
	var previousURL = "";
	var currentURL = selectPage1.options[index].value;
	var nextURL = "";

	if (index > 0) {
		previousURL = selectPage1.options[index - 1].value;
	}
	if (index + 1 < selectPage1.options.length) {
		nextURL = selectPage1.options[index + 1].value;
	}

	var $currentPage = $("#currentPage");
	$currentPage.attr("src", currentURL);
	var $nextPage = $("#nextPage");
	$nextPage.attr("src", nextURL);
	var $previousPage = $("#previousPage");
	$previousPage.attr("src", previousURL);
}