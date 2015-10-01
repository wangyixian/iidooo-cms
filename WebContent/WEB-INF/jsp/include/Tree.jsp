<script type="text/javascript" src="${SITE_URL}/js/jquery.treeview/jquery.treeview.js"></script>
<script type="text/javascript" src="${SITE_URL}/js/jquery.treeview/lib/jquery.cookie.js"></script>
<link type="text/css" rel="stylesheet" href="${SITE_URL}/js/jquery.treeview/jquery.treeview.css">
<script type="text/javascript">
	$(function() {
		var $tree = $("#tree");
		if ($tree != null) {
			$tree.treeview({
				animated : "fast",
				persist : "location"
			});
		}
	})
</script>