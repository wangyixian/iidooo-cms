$(function() {
		$("#tree").treeview({
			animated : "fast",
			persist : "location"
		});
	})
	
	var editor;
	KindEditor.ready(function(K) {
		editor = K.create('textarea[name="content.contentBody"]', {
			allowFileManager : true,
			uploadJson : 'fileUpload.action',
			fileManagerJson : 'kindEditorFileManager.action',
		});
		K('#btnImgTitle').click(function() {
			editor.loadPlugin('image', function() {
				editor.plugin.imageDialog({
					imageUrl : K('#txtImgTitle').val(),
					clickFn : function(url, title, width, height, border, align) {
						K('#txtImgTitle').val(url);
						K('#imgTitle').attr("src",url);
						editor.hideDialog();
					}
				});
			});
		});
	});
	
	function createContent() {
		editor.sync();
		window.form.action = "contentCreate.action";
		if(validate()){
			window.form.submit();
		}
	}

	function updateContent() {
		editor.sync();
		window.form.action = "contentUpdate.action";
		if(validate()){
			window.form.submit();
		}
	}
	
	function btnCopy(){
		editor.sync();
		$("#hidMode").val(3);
		window.form.action = "contentDetail.action";
		window.form.submit();
	}

	function deleteContent() {
		editor.sync();
		window.form.action = "contentDelete.action";
		window.form.submit();
	}

	function returnBack() {
		var channelID = $("#hidChannelID").val();
		window.location.href = "contentList.action?channelID=" + channelID;
	}
	
	function validate(){
		var message = "";
		var txtContentTitle = $("#txtContentTitle").val();		
		if(txtContentTitle == ""){
			message += "内容标题不能为空。";
		}
		if(message != ""){
			alert(message);
			return false;
		}
		return true;
	}