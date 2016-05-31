/**
 * Created by Ethan on 16/5/20.
 */

var ContentActions = Reflux.createActions(['save', 'getContent']);

var ContentStore = Reflux.createStore({
    listenables: [ContentActions],
    onSave: function (data) {
        var url = "";
        if (data.pageMode == "1") {
            url = URL.server + API.createContent;
        } else if (data.pageMode == "2") {
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
        var $pictureList = $("input[id^=pictureList]");
        var pictureList = [];
        $.each($pictureList, function (index, object) {
            pictureList[index] = object.value;
        });
        data.pictureList = JSON.stringify(pictureList);
        console.log(data);
        var self = this;
        var callback = function (result) {
            if (result.status == 200) {
                if (data.pageMode == "1") {
                    alert("内容创建成功，进入修改模式！");
                    location.href = Page.contentDetail + "?pageMode=2&contentID=" + result.data.contentID;
                } else {
                    alert("更新成功!");
                }
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
                result.data.pageMode = "2";
                if (result.data.contentType == "2") {
                    result.data.newsDisplay = "show";
                } else {
                    result.data.newsDisplay = "hidden";
                }

                if (result.data.pictureList.length > 0) {
                    $("#divContentImageList").attr("class", "show");
                    $.each(result.data.pictureList, function (index, object) {
                        // 加入上传路径
                        var $divInputPic = $("#divInputContentPic");
                        var $pictureList = $("<input type='text' class='form-control'/>");
                        $pictureList.val(object.pictureURL);
                        $pictureList.attr("id", "pictureList" + object.pictureID);
                        $divInputPic.append($pictureList);

                        // 删除按钮
                        var $divContentPicDelete = $("#divContentPicDelete");
                        var $deleteButton = $("<button type='button' class='btn btn-default' aria-label='Remove'>" +
                            "<span class='glyphicon glyphicon-remove' aria-hidden='true'></span>" +
                            "</button>");
                        $divContentPicDelete.append($deleteButton);

                        $deleteButton.bind("click", function () {
                            $("#pictureList" + object.pictureID).remove();
                            $(this).remove();

                            if ($("#divInputContentPic > input").length <= 0) {
                                $("#divContentImageList").attr("class", "hidden");
                            }
                        });
                    });
                }

                self.trigger(result.data);
            } else {
                console.log(result);
                alert("内容获取失败！");
            }
        };

        ajaxPost(url, data, callback);
    },
});

var Content = React.createClass({displayName: "Content",
    mixins: [Reflux.connect(ContentStore, 'content')],
    getInitialState: function () {
        return {
            content: {
                newsDisplay: "show",
                pageMode: 1,
                contentID: 0,
                channelID: 0,
                contentTitle: "",
                contentSubTitle: "",
                contentImageTitle: "",
                contentSummary: "",
                contentBody: "",
                stickyIndex: 0,
                isSilent: 0,
                status: "1",
                contentType: "0",
                startShowDate: "",
                endShowDate: "",
                startShowTime: "00:00:00",
                endShowTime: "23:59:59",
                source: "",
                sourceURL: "",
                metaDescription: "",
                metaTitle: "",
                metaKeywords: "",
                remarks: "",
                pictureList: []
            }
        };
    },
    componentWillMount: function () {
        this.state.content.pageMode = getQueryStr("pageMode");

        if (this.state.content.pageMode == "2") {
            this.state.content.contentID = getQueryStr("contentID");
            ContentActions.getContent(this.state.content);
        }
    },
    componentDidUpdate: function () {
        this.refs.inputStartShowDate.value = this.state.content.startShowDate;
        this.refs.inputEndShowDate.value = this.state.content.endShowDate;
        this.refs.inputStartShowTime.value = this.state.content.startShowTime;
        this.refs.inputEndShowTime.value = this.state.content.endShowTime;
        this.refs.inputImageTitle.value = this.state.content.contentImageTitle;
        showdownPreview(this.state.content.contentSummary, "txtSummaryPreview");
        showdownPreview(this.state.content.contentBody, "txtContentBodyPreview");

        if (this.state.content.pageMode == "2") {
            dataPermission("readOnlyAlert", this.state.content);
        }

    },
    onChildChanged: function (childState) {
        if (childState.channelID != null) {
            this.state.content.channelID = childState.channelID;
        }
        if (childState.contentType != null) {
            this.state.content.contentType = childState.contentType;
            switch (this.state.content.contentType) {
                case "1":
                    $("#newsFields").removeClass("show");
                    $("#newsFields").addClass("hidden");
                    break;
                case "2":
                    $("#newsFields").removeClass("hidden");
                    $("#newsFields").addClass("show");
                    break;
            }
        }
        if (childState.contentStatus != null) {
            this.state.content.status = childState.contentStatus;
        }
    },
    handleChange: function (key, event) {
        switch (key) {
            case "contentTitle":
                this.state.content.contentTitle = event.target.value;
                break;
            case "contentSubTitle":
                this.state.content.contentSubTitle = event.target.value;
                break;
            case "contentSummary":
                this.state.content.contentSummary = event.target.value;

                showdownPreview(this.state.content.contentSummary, "txtSummaryPreview");
                break;
            case "contentBody":
                this.state.content.contentBody = event.target.value;
                showdownPreview(this.state.content.contentBody, "txtContentBodyPreview");
                break;
            case "stickyIndex":
                this.state.content.stickyIndex = event.target.value;
                break;
            case "isSilent":
                if (event.target.checked) {
                    this.state.content.isSilent = 1;
                } else {
                    this.state.content.isSilent = 0;
                }
                break;
            case "source":
                this.state.content.source = event.target.value;
                break;
            case "sourceURL":
                this.state.content.sourceURL = event.target.value;
                break;
            case "metaDescription":
                this.state.content.metaDescription = event.target.value;
                break;
            case "metaTitle":
                this.state.content.metaTitle = event.target.value;
                break;
            case "metaKeywords":
                this.state.content.metaKeywords = event.target.value;
                break;
            case "remarks":
                this.state.content.remarks = event.target.value;
                break;
        }

        this.state.content.contentImageTitle = this.refs.inputImageTitle.value;
        this.state.content.contentBody = this.refs.inputContentBody.value;
        this.state.content.startShowDate = this.refs.inputStartShowDate.value;
        this.state.content.endShowDate = this.refs.inputEndShowDate.value;
        this.state.content.startShowTime = this.refs.inputStartShowTime.value;
        this.state.content.endShowTime = this.refs.inputEndShowTime.value;

        this.setState(this.state.content);
    },
    handleSave: function () {


        var url = API.createContent;
        if (this.state.content.pageMode == "2") {
            url = API.updateContent;
        }

        console.log(securityUser);
        if ($.inArray(url, securityUser.resUrlList) < 0 || securityUser.roleCode == role.readonly) {
            alert(Message.NO_PERMISSION);
            return false;
        }

        if (this.state.content.pageMode == "2") {
            if (dataPermission("readOnlyAlert", this.state.content)) {
                return false;
            }
        }

        this.state.content.contentImageTitle = this.refs.inputImageTitle.value;
        this.state.content.contentBody = this.refs.inputContentBody.value;
        this.state.content.startShowDate = this.refs.inputStartShowDate.value;
        this.state.content.endShowDate = this.refs.inputEndShowDate.value;
        this.state.content.startShowTime = this.refs.inputStartShowTime.value;
        this.state.content.endShowTime = this.refs.inputEndShowTime.value;
        ContentActions.save(this.state.content);
    },
    render: function () {
        return (
            React.createElement("div", null, 
                React.createElement(Header, {activeMenuID: "menuContentManage"}), 

                React.createElement("div", {className: "container"}, 
                    React.createElement("div", {id: "readOnlyAlert", className: "alert alert-warning text-center hidden", role: "alert"}), 
                    React.createElement("div", {className: "panel panel-primary"}, 
                        React.createElement("div", {className: "panel-heading"}, "内容发布"), 
                        React.createElement("div", {className: "panel-body"}, 
                            React.createElement("div", {className: "row form-horizontal form-group"}, 
                                React.createElement("div", {className: "col-xs-6"}, 
                                    React.createElement("div", {className: "col-xs-4 control-label"}, 
                                        React.createElement("label", {htmlFor: "channelID"}, "所属栏目")
                                    ), 
                                    React.createElement("div", {className: "col-xs-8"}, 
                                        React.createElement(ChannelList, {channelID: this.state.content.channelID, 
                                                     callbackParent: this.onChildChanged})
                                    )
                                ), 
                                React.createElement("div", {className: "col-xs-6"}, 
                                    React.createElement("div", {className: "col-xs-4 control-label"}, 
                                        React.createElement("label", null, "内容类型")
                                    ), 
                                    React.createElement("div", {className: "col-xs-8"}, 
                                        React.createElement(ContentTypeList, {contentType: this.state.content.contentType, 
                                                         callbackParent: this.onChildChanged})
                                    )
                                )
                            ), 
                            React.createElement("div", {className: "row form-group form-horizontal"}, 
                                React.createElement("div", {className: "col-xs-6"}, 
                                    React.createElement("div", {className: "col-xs-4 control-label"}, 
                                        React.createElement("label", null, "内容标题")
                                    ), 
                                    React.createElement("div", {className: "col-xs-8"}, 
                                        React.createElement("input", {type: "text", className: "form-control", 
                                               value: this.state.content.contentTitle, 
                                               onChange: this.handleChange.bind(null, 'contentTitle')})
                                    )
                                ), 
                                React.createElement("div", {className: "col-xs-6"}, 
                                    React.createElement("div", {className: "col-xs-4 control-label"}, 
                                        React.createElement("label", null, "内容副标题")
                                    ), 
                                    React.createElement("div", {className: "col-xs-8"}, 
                                        React.createElement("input", {type: "text", className: "form-control", 
                                               value: this.state.content.contentSubTitle, 
                                               onChange: this.handleChange.bind(null, 'contentSubTitle')})
                                    )
                                )
                            ), 

                            React.createElement("div", {className: "row form-group form-horizontal"}, 
                                React.createElement("div", {className: "col-xs-6"}, 
                                    React.createElement("div", {className: "col-xs-4 control-label"}, 
                                        React.createElement("label", null, "标题图")
                                    ), 
                                    React.createElement("div", {className: "col-xs-8"}, 
                                        React.createElement("input", {ref: "inputImageTitle", id: "contentImageTitle", type: "text", 
                                               className: "form-control"}), 
                                        React.createElement("img", {id: "imgImageTitle", src: ""})
                                    )
                                ), 
                                React.createElement("div", {className: "col-xs-6"}, 
                                    React.createElement("div", {className: "col-xs-4 control-label"}, 
                                        React.createElement("label", null, "标题图上传")
                                    ), 
                                    React.createElement("div", {className: "col-xs-8"}, 
                                        React.createElement("input", {id: "uploadImageTitle", type: "file", name: "file"})
                                    )
                                )
                            ), 

                            React.createElement("div", {className: "row form-group form-horizontal"}, 
                                React.createElement("div", {className: "col-xs-6"}, 
                                    React.createElement("div", {className: "col-xs-4 control-label"}, 
                                        React.createElement("label", null, "内容摘要")
                                    ), 
                                    React.createElement("div", {className: "col-xs-8"}, 
                                        React.createElement("textarea", {cols: "100", rows: "5", className: "form-control", 
                                                  value: this.state.content.contentSummary, 
                                                  onChange: this.handleChange.bind(null, 'contentSummary')})
                                    )
                                ), 
                                React.createElement("div", {className: "col-xs-6"}, 
                                    React.createElement("div", {className: "col-xs-4 control-label"}, 
                                        React.createElement("label", null, "预览")
                                    ), 
                                    React.createElement("div", {id: "txtSummaryPreview", className: "col-xs-8 markdownPreview"}
                                    )
                                )
                            ), 

                            React.createElement("div", {className: "row form-group form-horizontal"}, 
                                React.createElement("div", {className: "col-xs-6"}, 
                                    React.createElement("div", {className: "col-xs-4 control-label"}, 
                                        React.createElement("label", null, "内容主体")
                                    ), 
                                    React.createElement("div", {className: "col-xs-8"}, 
                                        React.createElement("input", {id: "uploadContentBodyImage", type: "file", name: "file"}), 
                                        React.createElement("select", {id: "selContentBodyFileType", className: "form-control", defaultValue: "3"}, 
                                            React.createElement("option", {value: "1"}, "方形头像(200*200)"), 
                                            React.createElement("option", {value: "2"}, "主页缩略图(500*500)"), 
                                            React.createElement("option", {value: "3"}, "详细大图(1000*1000)"), 
                                            React.createElement("option", {value: "4"}, "不压缩")
                                        ), 
                                        React.createElement("textarea", {id: "contentBody", ref: "inputContentBody", cols: "100", rows: "30", 
                                                  className: "form-control", 
                                                  value: this.state.content.contentBody, 
                                                  onChange: this.handleChange.bind(null, 'contentBody')})
                                    )
                                ), 
                                React.createElement("div", {className: "col-xs-6"}, 
                                    React.createElement("div", {className: "col-xs-4 control-label"}, 
                                        "预览"
                                    ), 
                                    React.createElement("div", {id: "txtContentBodyPreview", className: "col-xs-8 markdownPreview"}
                                    )
                                )
                            ), 

                            React.createElement("div", {className: "row form-group form-horizontal"}, 
                                React.createElement("div", {className: "col-xs-6"}, 
                                    React.createElement("div", {className: "col-xs-4 control-label"}, 
                                        React.createElement("label", null, "内容图上传")
                                    ), 
                                    React.createElement("div", {className: "col-xs-8"}, 
                                        React.createElement("input", {id: "uploadContentImage", type: "file", name: "file"})
                                    )
                                ), 
                                React.createElement("div", {className: "col-xs-6"}, 
                                    React.createElement("div", {className: "col-xs-4 control-label"}, 
                                        React.createElement("label", null, "图片压缩类型")
                                    ), 
                                    React.createElement("div", {className: "col-xs-8"}, 
                                        React.createElement("select", {id: "selFileType", className: "form-control", defaultValue: "2"}, 
                                            React.createElement("option", {value: "1"}, "方形头像(200*200)"), 
                                            React.createElement("option", {value: "2"}, "主页缩略图(500*500)"), 
                                            React.createElement("option", {value: "3"}, "详细大图(1000*1000)"), 
                                            React.createElement("option", {value: "4"}, "不压缩")
                                        )
                                    )
                                )
                            ), 

                            React.createElement("div", {id: "divContentImageList", className: "hidden"}, 
                                React.createElement("div", {className: "row form-group form-horizontal"}, 
                                    React.createElement("div", {className: "row"}, 
                                        React.createElement("div", {className: "col-xs-6"}, 
                                            React.createElement("div", {className: "col-xs-4 control-label"}, 
                                                React.createElement("label", null, "内容图列表")
                                            ), 
                                            React.createElement("div", {id: "divInputContentPic", className: "col-xs-8"}

                                            )
                                        ), 

                                        React.createElement("div", {className: "col-xs-6"}, 
                                            React.createElement("div", {id: "divContentPicDelete", className: "col-xs-2"}

                                            )
                                        )
                                    )
                                )
                            ), 

                            React.createElement("div", {className: "row form-group form-horizontal"}, 
                                React.createElement("div", {className: "col-xs-6"}, 
                                    React.createElement("div", {className: "col-xs-4 control-label"}, 
                                        React.createElement("label", null, "置顶索引")
                                    ), 
                                    React.createElement("div", {className: "col-xs-8"}, 
                                        React.createElement("input", {type: "number", className: "form-control", 
                                               value: this.state.content.stickyIndex, 
                                               onChange: this.handleChange.bind(null, 'stickyIndex')})
                                    )
                                ), 
                                React.createElement("div", {className: "col-xs-6"}, 
                                    React.createElement("div", {className: "col-xs-4 control-label"}, 
                                        React.createElement("label", null, "内容状态")
                                    ), 
                                    React.createElement("div", {className: "col-xs-6"}, 
                                        React.createElement(ContentStatusList, {contentStatus: this.state.content.status, 
                                                           callbackParent: this.onChildChanged})
                                    ), 
                                    React.createElement("div", {className: "col-xs-2 checkbox"}, 
                                        React.createElement("label", null, 
                                            React.createElement("input", {type: "checkbox", checked: this.state.content.isSilent, 
                                                   onChange: this.handleChange.bind(null, 'isSilent')}), "禁言"
                                        )
                                    )
                                )
                            ), 

                            React.createElement("div", {className: "row form-group form-horizontal"}, 
                                React.createElement("div", {className: "col-xs-6"}, 
                                    React.createElement("div", {className: "col-xs-4 control-label"}, 
                                        React.createElement("label", null, "显示开始日期")
                                    ), 
                                    React.createElement("div", {className: "col-xs-8"}, 
                                        React.createElement("div", {className: "input-group date form_date", "data-date": "", 
                                             "data-date-format": "yyyy-mm-dd", "data-link-field": "startShowDate", 
                                             "data-link-format": "yyyy-mm-dd"}, 
                                            React.createElement("input", {id: "startShowDate", className: "form-control", type: "text", 
                                                   readonly: true, value: this.state.content.startShowDate, 
                                                   onChange: this.handleChange.bind(null, 'startShowDate'), 
                                                   ref: "inputStartShowDate"}), 
                                                    React.createElement("span", {className: "input-group-addon"}, React.createElement("span", {
                                                        className: "glyphicon glyphicon-remove"})), 
                                                React.createElement("span", {className: "input-group-addon"}, React.createElement("span", {
                                                    className: "glyphicon glyphicon-calendar"}))
                                        )
                                    )
                                ), 
                                React.createElement("div", {className: "col-xs-6"}, 
                                    React.createElement("div", {className: "col-xs-4 control-label"}, 
                                        React.createElement("label", null, "显示结束日期")
                                    ), 
                                    React.createElement("div", {className: "col-xs-8"}, 
                                        React.createElement("div", {className: "input-group date form_date", "data-date": "", 
                                             "data-date-format": "yyyy-mm-dd", "data-link-field": "endShowDate", 
                                             "data-link-format": "yyyy-mm-dd"}, 
                                            React.createElement("input", {id: "endShowDate", className: "form-control", type: "text", 
                                                   value: this.state.content.endShowDate, 
                                                   onChange: this.handleChange.bind(null, 'endShowDate'), 
                                                   readonly: true, ref: "inputEndShowDate"}), 
                                                    React.createElement("span", {className: "input-group-addon"}, React.createElement("span", {
                                                        className: "glyphicon glyphicon-remove"})), 
                                React.createElement("span", {className: "input-group-addon"}, React.createElement("span", {
                                    className: "glyphicon glyphicon-calendar"}))
                                        )
                                    )
                                )
                            ), 

                            React.createElement("div", {className: "row form-group form-horizontal"}, 
                                React.createElement("div", {className: "col-xs-6"}, 
                                    React.createElement("div", {className: "col-xs-4 control-label"}, 
                                        React.createElement("label", null, "显示开始时间")
                                    ), 
                                    React.createElement("div", {className: "col-xs-8"}, 
                                        React.createElement("div", {className: "input-group date form_time", "data-date": "", 
                                             "data-date-format": "hh:ii:ss", "data-link-field": "startShowTime", 
                                             "data-link-format": "hh:ii:ss"}, 
                                            React.createElement("input", {id: "startShowTime", className: "form-control", type: "text", 
                                                   readonly: true, value: this.state.content.startShowTime, 
                                                   onChange: this.handleChange.bind(null, 'startShowTime'), 
                                                   ref: "inputStartShowTime"}), 
                                                    React.createElement("span", {className: "input-group-addon"}, React.createElement("span", {
                                                        className: "glyphicon glyphicon-remove"})), 
                                                    React.createElement("span", {className: "input-group-addon"}, React.createElement("span", {
                                                        className: "glyphicon glyphicon-time"}))
                                        )
                                    )
                                ), 
                                React.createElement("div", {className: "col-xs-6"}, 
                                    React.createElement("div", {className: "col-xs-4 control-label"}, 
                                        React.createElement("label", null, "显示结束时间")
                                    ), 
                                    React.createElement("div", {className: "col-xs-8"}, 
                                        React.createElement("div", {className: "input-group date form_time", "data-date": "", 
                                             "data-date-format": "hh:ii:ss", "data-link-field": "endShowTime", 
                                             "data-link-format": "hh:ii:ss"}, 
                                            React.createElement("input", {id: "endShowTime", className: "form-control", type: "text", 
                                                   readonly: true, value: this.state.content.endShowTime, 
                                                   onChange: this.handleChange.bind(null, 'endShowTime'), 
                                                   ref: "inputEndShowTime"}), 
                                                    React.createElement("span", {className: "input-group-addon"}, React.createElement("span", {
                                                        className: "glyphicon glyphicon-remove"})), 
                                                    React.createElement("span", {className: "input-group-addon"}, React.createElement("span", {
                                                        className: "glyphicon glyphicon-time"}))
                                        )
                                    )
                                )
                            ), 

                            React.createElement("div", {id: "newsFields", className: this.state.content.newsDisplay}, 
                                React.createElement("div", {className: "row form-group form-horizontal"}, 
                                    React.createElement("div", {className: "col-xs-6"}, 
                                        React.createElement("div", {className: "col-xs-4 control-label"}, 
                                            React.createElement("label", null, "新闻来源")
                                        ), 
                                        React.createElement("div", {className: "col-xs-8"}, 
                                            React.createElement("input", {type: "text", className: "form-control", 
                                                   value: this.state.content.source, 
                                                   onChange: this.handleChange.bind(null, 'source')})
                                        )
                                    ), 
                                    React.createElement("div", {className: "col-xs-6"}, 
                                        React.createElement("div", {className: "col-xs-4 control-label"}, 
                                            React.createElement("label", null, "新闻来源URL")
                                        ), 
                                        React.createElement("div", {className: "col-xs-8"}, 
                                            React.createElement("input", {type: "text", className: "form-control", 
                                                   value: this.state.content.sourceURL, 
                                                   onChange: this.handleChange.bind(null, 'sourceURL')})
                                        )
                                    )
                                )
                            ), 

                            React.createElement("div", {className: "row form-group form-horizontal"}, 
                                React.createElement("div", {className: "col-xs-6"}, 
                                    React.createElement("div", {className: "col-xs-4 control-label"}, 
                                        React.createElement("label", null, "备注")
                                    ), 
                                    React.createElement("div", {className: "col-xs-8"}, 
                                        React.createElement("textarea", {cols: "20", rows: "5", className: "form-control", 
                                                  value: this.state.content.remarks, 
                                                  onChange: this.handleChange.bind(null, 'remarks')})
                                    )
                                ), 
                                React.createElement("div", {className: "col-xs-6"}, 
                                    React.createElement("div", {className: "col-xs-4 control-label"}, 
                                        React.createElement("label", null, "MetaDescription")
                                    ), 
                                    React.createElement("div", {className: "col-xs-8"}, 
                                        React.createElement("textarea", {cols: "20", rows: "5", className: "form-control", 
                                                  value: this.state.content.metaDescription, 
                                                  onChange: this.handleChange.bind(null, 'metaDescription')})
                                    )
                                )
                            ), 

                            React.createElement("div", {className: "row form-group form-horizontal"}, 
                                React.createElement("div", {className: "col-xs-6"}, 
                                    React.createElement("div", {className: "col-xs-4 control-label"}, 
                                        React.createElement("label", null, "MetaTitle")
                                    ), 
                                    React.createElement("div", {className: "col-xs-8"}, 
                                        React.createElement("input", {type: "text", className: "form-control", 
                                               value: this.state.content.metaTitle, 
                                               onChange: this.handleChange.bind(null, 'metaTitle')})
                                    )
                                ), 
                                React.createElement("div", {className: "col-xs-6"}, 
                                    React.createElement("div", {className: "col-xs-4 control-label"}, 
                                        React.createElement("label", null, "MetaKeywords")
                                    ), 
                                    React.createElement("div", {className: "col-xs-8"}, 
                                        React.createElement("input", {type: "text", className: "form-control", 
                                               value: this.state.content.metaKeywords, 
                                               onChange: this.handleChange.bind(null, 'metaKeywords')})
                                    )
                                )
                            ), 

                            React.createElement("div", {className: "text-center"}, 
                                React.createElement("button", {className: "btn btn-primary", type: "button", onClick: this.handleSave}, "保 存"
                                ), 
                                " ", 
                                React.createElement("button", {className: "btn btn-danger", type: "button"}, "重 置")
                            )
                        )
                    )
                ), 
                React.createElement(Footer, null)
            )
        );
    }
});

ReactDOM.render(
    React.createElement(Content, null),
    document.getElementById('page')
);

$(function () {
    $('.form_date').datetimepicker({
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0,
        format: 'yyyy-mm-dd'
    });

    $('.form_time').datetimepicker({
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 1,
        minView: 0,
        maxView: 1,
        forceParse: 0,
        format: 'hh:ii:ss'
    });
});


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
            $imgImageTitle.css("width", '200px');
            $imgImageTitle.css("height", '200px');
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
            var contentBodyVal = $("#contentBody").val();
            $("#contentBody").val(contentBodyVal + "\r\n![](" + data.data.url + ")\r\n\r\n");

            var converter = new showdown.Converter();
            var rawMarkup = converter.makeHtml($("#contentBody").val());
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
            $("#divContentImageList").attr("class", "show");

            // 加入上传路径
            var $divInputPic = $("#divInputContentPic");
            var $pictureList = $("<input type='text' class='form-control'/>");
            $pictureList.val(data.data.url);
            var index = $("#divInputContentPic > input").length + 1;
            $pictureList.attr("id", "pictureList" + index);
            $divInputPic.append($pictureList);

            // 删除按钮
            var $divContentPicDelete = $("#divContentPicDelete");
            var $deleteButton = $("<button type='button' class='btn btn-default' aria-label='Remove'>" +
                "<span class='glyphicon glyphicon-remove' aria-hidden='true'></span>" +
                "</button>");
            $divContentPicDelete.append($deleteButton);

            $deleteButton.bind("click", function () {
                $("#pictureList" + index).remove();
                $(this).remove();

                if ($("#divInputContentPic > input").length <= 0) {
                    $("#divContentImageList").attr("class", "hidden");
                }
            });
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