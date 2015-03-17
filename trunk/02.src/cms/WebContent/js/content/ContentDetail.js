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
		var txtContentType = $("#txtContentType").val();
		var txtContentTitle = $("#txtContentTitle").val();
		
		var result = true;
		if(txtContentType == ""){
			$("#txtContentType").parent().attr("class","required_highlight");
			result = false;
		}
		if(txtContentTitle == ""){
			$("#txtContentTitle").parent().attr("class","required_highlight");			
			result = false;
		}
		
		if(result == false){
			alert("必填项不能为空！");
		}
		
		return result;
	}