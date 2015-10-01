<script type="text/javascript" src="${SITE_URL}/js/KindEditor/kindeditor-min.js"></script>
<script type="text/javascript" src="${SITE_URL}/js/KindEditor/lang/zh_CN.js"></script>
<script type="text/javascript">
	var editor;
	KindEditor.ready(function(K) {
		editor = K.create('textarea[class="kind_editor"]', {
			allowFileManager : true,
			uploadJson : 'fileUpload.action',
			fileManagerJson : 'kindEditorFileManager.action',
		});
		K('#btnImgTitle').click(
				function() {
					editor.loadPlugin('image', function() {
						editor.plugin.imageDialog({
							imageUrl : K('#txtImgTitle').val(),
							clickFn : function(url, title, width, height,
									border, align) {
								K('#txtImgTitle').val(url);
								K('#imgTitle').attr("src", url);
								editor.hideDialog();
							}
						});
					});
				});
	});
</script>