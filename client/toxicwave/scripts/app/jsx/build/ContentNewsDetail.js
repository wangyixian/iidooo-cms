/**
 * Created by Ethan on 16/5/20.
 */

var PageActions = Reflux.createActions(['save', 'getContent', 'delete']);

var PageStore = Reflux.createStore({
    listenables: [PageActions],
    onSave: function (data) {
        var pageMode = sessionStorage.getItem(SessionKey.pageMode);
        var url = "";
        if (pageMode == "1") {
            url = URL.server + API.createContent;
        } else if (pageMode == "2") {
            url = URL.server + API.updateContent;
        } else {
            alert("请指定正确的pageMode参数！");
            return false;
        }
        data.appID = SecurityClient.appID;
        data.secret = SecurityClient.secret;
        data.accessToken = sessionStorage.getItem(SessionKey.accessToken);
        data.userID = sessionStorage.getItem(SessionKey.userID);
        // 检查token是否过期
        if (data.accessToken == null || data.accessToken == "" || data.userID == null || data.userID == "") {
            location.href = Page.login;
            return false;
        }

        // 内容图片列表解析成json
        var $pictureList = $("img[id^=contentPicture]");
        var pictureList = [];
        $.each($pictureList, function (index, object) {
            pictureList[index] = object.src;
        });
        data.pictureList = JSON.stringify(pictureList);

        data.channelID = 1;
        data.contentType = "2";
        data.status = "1";

        var self = this;
        var callback = function (result) {
            if (result.status == 200) {
                alert("内容保存成功，主编审核通过后会自动发布到毒电波APP！");
                location.href = Page.myContentList;
            } else {
                console.log(result);
                alert("内容保存失败！");
            }
        };

        ajaxPost(url, data, callback);
    },
    onGetContent: function (data) {
        var url = URL.server + API.getContent;
        data.appID = SecurityClient.appID;
        data.secret = SecurityClient.secret;
        data.accessToken = sessionStorage.getItem(SessionKey.accessToken);
        data.userID = sessionStorage.getItem(SessionKey.userID);
        // 检查token是否过期
        if (data.accessToken == null || data.accessToken == "" || data.userID == null || data.userID == "") {
            location.href = Page.login;
            return false;
        }

        var self = this;
        var callback = function (result) {
            if (result.status == 200) {
                if (result.data.pictureList.length > 0) {
                    $.each(result.data.pictureList, function (index, object) {
                        createContentPicture(object.pictureURL);
                    });
                }
                self.trigger(result.data);
            } else {
                console.log(result);
            }
        };

        ajaxPost(url, data, callback);
    },
    onDelete: function (data) {
        var url = URL.server + API.deleteContent;
        data.appID = SecurityClient.appID;
        data.secret = SecurityClient.secret;
        data.accessToken = sessionStorage.getItem(SessionKey.accessToken);
        data.userID = sessionStorage.getItem(SessionKey.userID);
        // 检查token是否过期
        if (data.accessToken == null || data.accessToken == "" || data.userID == null || data.userID == "") {
            location.href = Page.login;
            return false;
        }

        var self = this;
        var callback = function (result) {
            if (result.status == 200) {
                location.href = Page.myContentList;
            } else {
                alert("删除出现异常，请联系管理员");
                console.log(result);
            }
        };

        ajaxPost(url, data, callback);
    },
});


var ContentNewsForm = React.createClass({displayName: "ContentNewsForm",
    mixins: [Reflux.connect(PageStore, 'content')],
    getInitialState: function () {
        return {
            content: {
                contentTitle: "",
                contentSubTitle:"",
                contentImageTitle: "",
                contentSummary: "",
                contentBody: "",
                source: "",
                sourceURL: ""
            }
        };
    },
    componentWillMount: function () {
        var pageMode = sessionStorage.getItem(SessionKey.pageMode);
        if (pageMode == "2") {
            this.state.content.contentID = sessionStorage.getItem(SessionKey.contentID);
            PageActions.getContent(this.state.content);
        }
    },
    componentDidUpdate: function () {
        this.refs.inputContentTitle.value = this.state.content.contentTitle;
        this.refs.inputContentSubTitle.value = this.state.content.contentSubTitle;
        $("#imgImageTitle").attr("src", this.state.content.contentImageTitle);
        this.refs.inputImageTitle.value = this.state.content.contentImageTitle;
        this.refs.inputContentSummary.value = this.state.content.contentSummary;
        this.refs.inputContentBody.value = this.state.content.contentBody;
        this.refs.inputSource.value = this.state.content.source;
        this.refs.inputSourceURL.value = this.state.content.sourceURL;
        showdownPreview(this.refs.inputContentSummary.value, "txtSummaryPreview");
        showdownPreview(this.refs.inputContentBody.value, "txtContentBodyPreview");
    },
    handleChange: function (key, event) {
        switch (key) {
            case "contentSummary":
                showdownPreview(this.refs.inputContentSummary.value, "txtSummaryPreview");
                break;
            case "contentBody":
                showdownPreview(this.refs.inputContentBody.value, "txtContentBodyPreview");
                break;
        }
    },
    handleReset: function () {
        this.refs.inputContentTitle.value = this.state.content.contentTitle;
        this.refs.inputContentSubTitle.value = this.state.content.contentSubTitle;
        if(this.state.content.contentImageTitle == "") {
            $("#imgImageTitle").attr("src", "../img/upload.png");
        } else{
            $("#imgImageTitle").attr("src", this.state.content.contentImageTitle );
        }
        this.refs.inputImageTitle.value = this.state.content.contentImageTitle;
        this.refs.inputContentSummary.value = this.state.content.contentSummary;
        this.refs.inputContentBody.value = this.state.content.contentBody;
        this.refs.inputSource.value = this.state.content.source;
        this.refs.inputSourceURL.value = this.state.content.sourceURL;
        showdownPreview(this.refs.inputContentSummary.value, "txtSummaryPreview");
        showdownPreview(this.refs.inputContentBody.value, "txtContentBodyPreview");
    },
    handleSave: function () {
        this.state.content.contentTitle = this.refs.inputContentTitle.value;
        this.state.content.contentSubTitle = this.refs.inputContentSubTitle.value;
        this.state.content.contentImageTitle = this.refs.inputImageTitle.value;
        this.state.content.contentSummary = this.refs.inputContentSummary.value;
        this.state.content.contentBody = this.refs.inputContentBody.value;
        this.state.content.source = this.refs.inputSource.value;
        this.state.content.sourceURL = this.refs.inputSourceURL.value;

        if (this.state.content.contentTitle == "" || this.state.content.contentBody == "") {
            $("#inputContentTitle").addClass("input-error");
            $("#inputContentBody").addClass("input-error");
            $("#btnImageTitle").addClass("input-error");
            alert(Message.INPUT_REQUIRED);
            return false;
        }

        PageActions.save(this.state.content);
    },
    handleUploadFile: function (fileID) {
        openFileBrowse(fileID);
    },
    render: function () {
        var deleteButton;
        if (sessionStorage.getItem(SessionKey.pageMode) == "2") {
            deleteButton = React.createElement(DeleteButton, {content: this.state.content})
        }
        return (
            React.createElement("div", null, 
                React.createElement("div", {className: "container"}, 
                    React.createElement("div", {className: "panel panel-primary"}, 
                        React.createElement("div", {className: "panel-heading"}, "来一发毒电波压压惊"), 
                        React.createElement("div", {className: "panel-body"}, 
                            React.createElement("div", {className: "row form-group form-horizontal"}, 
                                React.createElement("div", {className: "col-xs-6"}, 
                                    React.createElement("div", {className: "col-xs-3 control-label"}, 
                                        React.createElement("label", {className: "required"}, "标题")
                                    ), 
                                    React.createElement("div", {className: "col-xs-9"}, 
                                        React.createElement("input", {id: "inputContentTitle", ref: "inputContentTitle", type: "text", 
                                               className: "form-control"})
                                    )
                                ), 
                                React.createElement("div", {className: "col-xs-6"}, 
                                    React.createElement("div", {className: "col-xs-3 control-label"}, 
                                        React.createElement("label", null, "副标题")
                                    ), 
                                    React.createElement("div", {className: "col-xs-9"}, 
                                        React.createElement("input", {ref: "inputContentSubTitle", type: "text", className: "form-control"})
                                    )
                                )
                            ), 

                            React.createElement("div", {className: "row form-group form-horizontal"}, 
                                React.createElement("div", {className: "col-xs-6"}, 
                                    React.createElement("div", {className: "col-xs-3 control-label"}, 
                                        React.createElement("label", null, "毒电波来源")
                                    ), 
                                    React.createElement("div", {className: "col-xs-9"}, 
                                        React.createElement("input", {id: "inputSource", ref: "inputSource", type: "text", className: "form-control"})
                                    )
                                ), 
                                React.createElement("div", {className: "col-xs-6"}, 
                                    React.createElement("div", {className: "col-xs-3 control-label"}, 
                                        React.createElement("label", null, "毒电波来源URL")
                                    ), 
                                    React.createElement("div", {className: "col-xs-9"}, 
                                        React.createElement("input", {id: "inputSourceURL", ref: "inputSourceURL", type: "text", 
                                               className: "form-control"})
                                    )
                                )
                            ), 

                            React.createElement("div", {className: "row form-group form-horizontal"}, 
                                React.createElement("div", {className: "col-xs-6"}, 
                                    React.createElement("div", {className: "col-xs-3 control-label"}, 
                                        React.createElement("label", null, "摘要")
                                    ), 
                                    React.createElement("div", {className: "col-xs-9"}, 
                                        React.createElement("textarea", {ref: "inputContentSummary", cols: "100", rows: "6", 
                                                  className: "form-control"})
                                    )
                                ), 
                                React.createElement("div", {className: "col-xs-6"}, 
                                    React.createElement("div", {className: "col-xs-3 control-label"}, 
                                        React.createElement("label", {className: "required"}, "微信分享图")
                                    ), 
                                    React.createElement("div", {className: "col-xs-9"}, 
                                        React.createElement("button", {id: "btnImageTitle", type: "button", className: "btn btn-info btn-block", 
                                                onClick: this.handleUploadFile.bind(null, 'uploadImageTitle')}, 
                                            "上传微信分享显示的图片"
                                        ), 
                                        React.createElement("input", {id: "uploadImageTitle", type: "file", name: "file", className: "hidden"}), 
                                        React.createElement("input", {ref: "inputImageTitle", id: "contentImageTitle", type: "text", 
                                               className: "hidden"}), 

                                        React.createElement("div", null, 
                                            React.createElement("img", {id: "imgImageTitle", src: "../img/upload.png", className: "img-square-100", 
                                                 alt: "预览"})
                                        )
                                    )
                                )
                            ), 

                            React.createElement("div", {className: "row form-group form-horizontal"}, 
                                React.createElement("div", {className: "col-xs-6"}, 
                                    React.createElement("div", {className: "col-xs-3 control-label"}, 
                                        React.createElement("label", null, "主页展示图上传")
                                    ), 
                                    React.createElement("div", {className: "col-xs-9"}, 
                                        React.createElement("div", {className: "form-inline"}, 
                                            React.createElement("button", {type: "button", className: "btn btn-info", 
                                                    onClick: this.handleUploadFile.bind(null, 'uploadContentImage')}, 
                                                "上传主页展示的图片"
                                            ), 
                                            React.createElement("input", {id: "uploadContentImage", type: "file", name: "file", className: "hidden"}), 
                                            " ", 
                                            React.createElement("select", {id: "selFileType", className: "form-control", 
                                                    defaultValue: "2"}, 
                                                React.createElement("option", {value: "1"}, "方形头像(200*200)"), 
                                                React.createElement("option", {value: "2"}, "主页缩略图(500*500)"), 
                                                React.createElement("option", {value: "3"}, "详细大图(1000*1000)"), 
                                                React.createElement("option", {value: "4"}, "不压缩")
                                            )
                                        )
                                    )
                                )
                            ), 
                            React.createElement("div", {className: "row form-group form-horizontal"}, 
                                React.createElement("div", {className: "col-xs-6"}, 
                                    React.createElement("div", {className: "col-xs-3"}
                                    ), 
                                    React.createElement("div", {id: "divInputContentPic", className: "col-xs-9"}
                                    )
                                )
                            ), 

                            React.createElement("div", {className: "row form-group form-horizontal"}, 
                                React.createElement("div", {className: "col-xs-6"}, 
                                    React.createElement("div", {className: "col-xs-3 control-label"}, 
                                        React.createElement("label", {className: "required"}, "正文")
                                    ), 
                                    React.createElement("div", {className: "col-xs-9"}, 
                                        React.createElement("div", {className: "form-inline"}, 
                                            React.createElement("button", {type: "button", className: "btn btn-info", 
                                                    onClick: this.handleUploadFile.bind(null, 'uploadContentBodyImage')}, 
                                                "上传正文显示的图片"
                                            ), 
                                            React.createElement("input", {id: "uploadContentBodyImage", type: "file", name: "file", 
                                                   className: "hidden"}), 
                                            " ", 
                                            React.createElement("select", {id: "selContentBodyFileType", className: "form-control", 
                                                    defaultValue: "3"}, 
                                                React.createElement("option", {value: "1"}, "方形头像(200*200)"), 
                                                React.createElement("option", {value: "2"}, "主页缩略图(500*500)"), 
                                                React.createElement("option", {value: "3"}, "详细大图(1000*1000)"), 
                                                React.createElement("option", {value: "4"}, "不压缩")
                                            )
                                        )
                                    )
                                ), 
                                React.createElement("div", {className: "col-xs-6"}, 
                                    React.createElement("div", {className: "col-xs-3 control-label"}, 
                                        React.createElement("a", {href: "http://iidooo-toxic-wave.oss-cn-shanghai.aliyuncs.com/resources/img/markdown-tips.jpg", 
                                           target: "_blank"}, "编辑样式说明")
                                    )
                                )
                            ), 

                            React.createElement("div", {className: "row form-group form-horizontal"}, 
                                React.createElement("div", {className: "col-xs-6"}, 
                                    React.createElement("div", {className: "col-xs-3 control-label"}

                                    ), 
                                    React.createElement("div", {className: "col-xs-9"}, 
                                        React.createElement("textarea", {id: "inputContentBody", ref: "inputContentBody", cols: "100", rows: "25", 
                                                  className: "form-control", 
                                                  onChange: this.handleChange.bind(null, 'contentBody')})
                                    )
                                ), 
                                React.createElement("div", {className: "col-xs-6"}, 
                                    React.createElement("div", {className: "col-xs-3 control-label"}
                                    ), 
                                    React.createElement("div", {id: "txtContentBodyPreview", className: "col-xs-9 markdownPreview"}
                                    )
                                )
                            ), 

                            React.createElement("div", {className: "text-center"}, 
                                React.createElement("button", {className: "btn btn-primary", type: "button", onClick: this.handleSave}, "保 存"
                                ), 
                                " ", 
                                React.createElement("button", {className: "btn btn-warning", type: "button", onClick: this.handleReset}, "重 置"
                                ), 
                                " ", deleteButton
                            )
                        )
                    )
                )
            )
        );
    }
});

var DeleteButton = React.createClass({displayName: "DeleteButton",
    handleDelete: function () {
        if (window.confirm('确定要删除吗？')) {
            PageActions.delete(this.props.content);
        }
    },
    render: function () {
        return (
            React.createElement("button", {className: "btn btn-danger", type: "button", onClick: this.handleDelete}, "删 除"
            )
        );
    }
});

var ContentNewsPage = React.createClass({displayName: "ContentNewsPage",
    onChildChanged: function (childState) {
    },
    render: function () {
        return (
            React.createElement("div", null, 
                React.createElement(Header, {activeMenuID: "menuCreateNews"}), 
                React.createElement(ContentNewsForm, null), 
                React.createElement(Footer, null)
            )
        );
    }
});

ReactDOM.render(
    React.createElement(ContentNewsPage, null),
    document.getElementById('page')
);

// 上传标题图
$("#uploadImageTitle").fileupload({
    url: URL.server + API.uploadFile,
    dataType: 'json',
    autoUpload: true,
    acceptFileTypes: /(\.|\/)(jpe?g|png|gif)$/i,
    maxNumberOfFiles: 1,
    formData: {
        'appID': SecurityClient.appID,
        'secret': SecurityClient.secret,
        'accessToken': sessionStorage.getItem(SessionKey.accessToken),
        'fileType': '1'
    },
    maxFileSize: 10000000,
    done: function (e, result) {
        var data = result.result;
        if (data.status == "200") {
            $("#contentImageTitle").val(data.data.url);
            var $imgImageTitle = $("#imgImageTitle");
            $imgImageTitle.attr("src", data.data.url);
            $imgImageTitle.css("width", '100px');
            $imgImageTitle.css("height", '100px');
        } else {
            alert("请求接收但处理失败，请联系管理员！");
            console.log(data);
        }
    },
    progressall: function (e, data) {
        var progress = parseInt(data.loaded / data.total * 100, 10) + "%";

        console.log(progress);
    },
    error: function (e, data) {

        console.log('Error!');
    },
    fail: function (e, data) {

        console.log('Fail!');
    }
});

// 上传内容主体图
$("#uploadContentBodyImage").fileupload({
    url: URL.server + API.uploadFile,
    dataType: 'json',
    autoUpload: true,
    acceptFileTypes: /(\.|\/)(jpe?g|png|gif)$/i,
    maxNumberOfFiles: 1,
    maxFileSize: 10000000,
    done: function (e, result) {
        var data = result.result;
        if (data.status == "200") {
            var contentBodyVal = $("#inputContentBody").val();
            $("#inputContentBody").val(contentBodyVal + "![](" + data.data.url + ")\r\n\r\n");

            var converter = new showdown.Converter();
            var rawMarkup = converter.makeHtml($("#inputContentBody").val());
            $("#txtContentBodyPreview").html(rawMarkup);

        } else {
            alert("服务器端处理失败，出现异常，请联系管理员！");
            console.log(data);
        }
    },
    progressall: function (e, data) {
        var progress = parseInt(data.loaded / data.total * 100, 10) + "%";

        console.log(progress);
    },
    error: function (e, data) {

        console.log('Error!');
    },
    fail: function (e, data) {

        console.log('Fail!');
    }
});

//文件上传前触发事件
$('#uploadContentBodyImage').bind('fileuploadsubmit', function (e, data) {
    data.formData = {
        'appID': SecurityClient.appID,
        'secret': SecurityClient.secret,
        'accessToken': sessionStorage.getItem(SessionKey.accessToken),
        'fileType': $("#selContentBodyFileType").val()
    };  //如果需要额外添加参数可以在这里添加
});

// 上传内容图片列表
$("#uploadContentImage").fileupload({
    url: URL.server + API.uploadFile,
    dataType: 'json',
    autoUpload: true,
    acceptFileTypes: /(\.|\/)(jpe?g|png|gif)$/i,
    maxNumberOfFiles: 1,
    //formData: {'appID': appID, 'secret': secret, 'accessToken': accessToken, 'fileType': $("#selFileType").val()},
    maxFileSize: 10000000,
    done: function (e, result) {
        var data = result.result;
        if (data.status == "200") {

            createContentPicture(data.data.url);
        } else {
            alert("服务器端处理失败，出现异常，请联系管理员！");
            console.log(data);
        }
    },
    progressall: function (e, data) {
        var progress = parseInt(data.loaded / data.total * 100, 10) + "%";

        console.log(progress);
    },
    error: function (e, data) {

        console.log('Error!');
    },
    fail: function (e, data) {

        console.log('Fail!');
    }
});

//文件上传前触发事件
$('#uploadContentImage').bind('fileuploadsubmit', function (e, data) {
    data.formData = {
        'appID': SecurityClient.appID,
        'secret': SecurityClient.secret,
        'accessToken': sessionStorage.getItem(SessionKey.accessToken),
        'fileType': $("#selFileType").val()
    };  //如果需要额外添加参数可以在这里添加
});

function createContentPicture(url){
    // 加入上传路径
    var $divInputPic = $("#divInputContentPic");
    var index = $("#divInputContentPic > div").length + 1;

    var $div = $("<div class='float-left text-center content-picture'></div>");
    $div.attr("id", "contentPictureWrap" + index);

    var $divPicture = $("<div></div>");
    var $picture = $("<img class='img-square-100'/>");
    $picture.attr("src", url);
    $picture.attr("id", "contentPicture" + index);
    $divPicture.append($picture);
    $div.append($divPicture);

    var $divButton = $("<div></div>");
    // 删除按钮
    var $deleteButton = $("<button type='button' class='btn btn-danger btn-block btn-xs'>删除</button>");
    $divButton.append($deleteButton);
    $div.append($divButton);
    $deleteButton.bind("click", function () {
        $("#contentPictureWrap" + index).remove();
        $(this).remove();
    });

    $divInputPic.append($div);
}