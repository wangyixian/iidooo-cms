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

var Content = React.createClass({
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
            <div>
                <Header activeMenuID="menuContentManage"/>

                <div className="container">
                    <div id="readOnlyAlert" className="alert alert-warning text-center hidden" role="alert"></div>
                    <div className="panel panel-primary">
                        <div className="panel-heading">内容发布</div>
                        <div className="panel-body">
                            <div className="row form-horizontal form-group">
                                <div className="col-xs-6">
                                    <div className="col-xs-4 control-label">
                                        <label htmlFor="channelID">所属栏目</label>
                                    </div>
                                    <div className="col-xs-8">
                                        <ChannelList channelID={this.state.content.channelID}
                                                     callbackParent={this.onChildChanged}/>
                                    </div>
                                </div>
                                <div className="col-xs-6">
                                    <div className="col-xs-4 control-label">
                                        <label>内容类型</label>
                                    </div>
                                    <div className="col-xs-8">
                                        <ContentTypeList contentType={this.state.content.contentType}
                                                         callbackParent={this.onChildChanged}/>
                                    </div>
                                </div>
                            </div>
                            <div className="row form-group form-horizontal">
                                <div className="col-xs-6">
                                    <div className="col-xs-4 control-label">
                                        <label>内容标题</label>
                                    </div>
                                    <div className="col-xs-8">
                                        <input type="text" className="form-control"
                                               value={this.state.content.contentTitle}
                                               onChange={this.handleChange.bind(null, 'contentTitle')}/>
                                    </div>
                                </div>
                                <div className="col-xs-6">
                                    <div className="col-xs-4 control-label">
                                        <label>内容副标题</label>
                                    </div>
                                    <div className="col-xs-8">
                                        <input type="text" className="form-control"
                                               value={this.state.content.contentSubTitle}
                                               onChange={this.handleChange.bind(null, 'contentSubTitle')}/>
                                    </div>
                                </div>
                            </div>

                            <div className="row form-group form-horizontal">
                                <div className="col-xs-6">
                                    <div className="col-xs-4 control-label">
                                        <label>标题图</label>
                                    </div>
                                    <div className="col-xs-8">
                                        <input ref="inputImageTitle" id="contentImageTitle" type="text"
                                               className="form-control"/>
                                        <img id="imgImageTitle" src=""/>
                                    </div>
                                </div>
                                <div className="col-xs-6">
                                    <div className="col-xs-4 control-label">
                                        <label>标题图上传</label>
                                    </div>
                                    <div className="col-xs-8">
                                        <input id="uploadImageTitle" type="file" name="file"/>
                                    </div>
                                </div>
                            </div>

                            <div className="row form-group form-horizontal">
                                <div className="col-xs-6">
                                    <div className="col-xs-4 control-label">
                                        <label>内容摘要</label>
                                    </div>
                                    <div className="col-xs-8">
                                        <textarea cols="100" rows="5" className="form-control"
                                                  value={this.state.content.contentSummary}
                                                  onChange={this.handleChange.bind(null, 'contentSummary')}></textarea>
                                    </div>
                                </div>
                                <div className="col-xs-6">
                                    <div className="col-xs-4 control-label">
                                        <label>预览</label>
                                    </div>
                                    <div id="txtSummaryPreview" className="col-xs-8 markdownPreview">
                                    </div>
                                </div>
                            </div>

                            <div className="row form-group form-horizontal">
                                <div className="col-xs-6">
                                    <div className="col-xs-4 control-label">
                                        <label>内容主体</label>
                                    </div>
                                    <div className="col-xs-8">
                                        <input id="uploadContentBodyImage" type="file" name="file"/>
                                        <select id="selContentBodyFileType" className="form-control" defaultValue="3">
                                            <option value="1">方形头像(200*200)</option>
                                            <option value="2">主页缩略图(500*500)</option>
                                            <option value="3">详细大图(1000*1000)</option>
                                            <option value="4">不压缩</option>
                                        </select>
                                        <textarea id="contentBody" ref="inputContentBody" cols="100" rows="30"
                                                  className="form-control"
                                                  value={this.state.content.contentBody}
                                                  onChange={this.handleChange.bind(null, 'contentBody')}></textarea>
                                    </div>
                                </div>
                                <div className="col-xs-6">
                                    <div className="col-xs-4 control-label">
                                        预览
                                    </div>
                                    <div id="txtContentBodyPreview" className="col-xs-8 markdownPreview">
                                    </div>
                                </div>
                            </div>

                            <div className="row form-group form-horizontal">
                                <div className="col-xs-6">
                                    <div className="col-xs-4 control-label">
                                        <label>内容图上传</label>
                                    </div>
                                    <div className="col-xs-8">
                                        <input id="uploadContentImage" type="file" name="file"/>
                                    </div>
                                </div>
                                <div className="col-xs-6">
                                    <div className="col-xs-4 control-label">
                                        <label>图片压缩类型</label>
                                    </div>
                                    <div className="col-xs-8">
                                        <select id="selFileType" className="form-control" defaultValue="2">
                                            <option value="1">方形头像(200*200)</option>
                                            <option value="2">主页缩略图(500*500)</option>
                                            <option value="3">详细大图(1000*1000)</option>
                                            <option value="4">不压缩</option>
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <div id="divContentImageList" className="hidden">
                                <div className="row form-group form-horizontal">
                                    <div className="row">
                                        <div className="col-xs-6">
                                            <div className="col-xs-4 control-label">
                                                <label>内容图列表</label>
                                            </div>
                                            <div id="divInputContentPic" className="col-xs-8">

                                            </div>
                                        </div>

                                        <div className="col-xs-6">
                                            <div id="divContentPicDelete" className="col-xs-2">

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div className="row form-group form-horizontal">
                                <div className="col-xs-6">
                                    <div className="col-xs-4 control-label">
                                        <label>置顶索引</label>
                                    </div>
                                    <div className="col-xs-8">
                                        <input type="number" className="form-control"
                                               value={this.state.content.stickyIndex}
                                               onChange={this.handleChange.bind(null, 'stickyIndex')}/>
                                    </div>
                                </div>
                                <div className="col-xs-6">
                                    <div className="col-xs-4 control-label">
                                        <label>内容状态</label>
                                    </div>
                                    <div className="col-xs-6">
                                        <ContentStatusList contentStatus={this.state.content.status}
                                                           callbackParent={this.onChildChanged}/>
                                    </div>
                                    <div className="col-xs-2 checkbox">
                                        <label>
                                            <input type="checkbox" checked={this.state.content.isSilent}
                                                   onChange={this.handleChange.bind(null, 'isSilent')}/>禁言
                                        </label>
                                    </div>
                                </div>
                            </div>

                            <div className="row form-group form-horizontal">
                                <div className="col-xs-6">
                                    <div className="col-xs-4 control-label">
                                        <label>显示开始日期</label>
                                    </div>
                                    <div className="col-xs-8">
                                        <div className="input-group date form_date" data-date=""
                                             data-date-format="yyyy-mm-dd" data-link-field="startShowDate"
                                             data-link-format="yyyy-mm-dd">
                                            <input id="startShowDate" className="form-control" type="text"
                                                   readonly value={this.state.content.startShowDate}
                                                   onChange={this.handleChange.bind(null, 'startShowDate')}
                                                   ref="inputStartShowDate"/>
                                                    <span className="input-group-addon"><span
                                                        className="glyphicon glyphicon-remove"></span></span>
                                                <span className="input-group-addon"><span
                                                    className="glyphicon glyphicon-calendar"></span></span>
                                        </div>
                                    </div>
                                </div>
                                <div className="col-xs-6">
                                    <div className="col-xs-4 control-label">
                                        <label>显示结束日期</label>
                                    </div>
                                    <div className="col-xs-8">
                                        <div className="input-group date form_date" data-date=""
                                             data-date-format="yyyy-mm-dd" data-link-field="endShowDate"
                                             data-link-format="yyyy-mm-dd">
                                            <input id="endShowDate" className="form-control" type="text"
                                                   value={this.state.content.endShowDate}
                                                   onChange={this.handleChange.bind(null, 'endShowDate')}
                                                   readonly ref="inputEndShowDate"/>
                                                    <span className="input-group-addon"><span
                                                        className="glyphicon glyphicon-remove"></span></span>
                                <span className="input-group-addon"><span
                                    className="glyphicon glyphicon-calendar"></span></span>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div className="row form-group form-horizontal">
                                <div className="col-xs-6">
                                    <div className="col-xs-4 control-label">
                                        <label>显示开始时间</label>
                                    </div>
                                    <div className="col-xs-8">
                                        <div className="input-group date form_time" data-date=""
                                             data-date-format="hh:ii:ss" data-link-field="startShowTime"
                                             data-link-format="hh:ii:ss">
                                            <input id="startShowTime" className="form-control" type="text"
                                                   readonly value={this.state.content.startShowTime}
                                                   onChange={this.handleChange.bind(null, 'startShowTime')}
                                                   ref="inputStartShowTime"/>
                                                    <span className="input-group-addon"><span
                                                        className="glyphicon glyphicon-remove"></span></span>
                                                    <span className="input-group-addon"><span
                                                        className="glyphicon glyphicon-time"></span></span>
                                        </div>
                                    </div>
                                </div>
                                <div className="col-xs-6">
                                    <div className="col-xs-4 control-label">
                                        <label>显示结束时间</label>
                                    </div>
                                    <div className="col-xs-8">
                                        <div className="input-group date form_time" data-date=""
                                             data-date-format="hh:ii:ss" data-link-field="endShowTime"
                                             data-link-format="hh:ii:ss">
                                            <input id="endShowTime" className="form-control" type="text"
                                                   readonly value={this.state.content.endShowTime}
                                                   onChange={this.handleChange.bind(null, 'endShowTime')}
                                                   ref="inputEndShowTime"/>
                                                    <span className="input-group-addon"><span
                                                        className="glyphicon glyphicon-remove"></span></span>
                                                    <span className="input-group-addon"><span
                                                        className="glyphicon glyphicon-time"></span></span>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div id="newsFields" className={this.state.content.newsDisplay}>
                                <div className="row form-group form-horizontal">
                                    <div className="col-xs-6">
                                        <div className="col-xs-4 control-label">
                                            <label>新闻来源</label>
                                        </div>
                                        <div className="col-xs-8">
                                            <input type="text" className="form-control"
                                                   value={this.state.content.source}
                                                   onChange={this.handleChange.bind(null, 'source')}/>
                                        </div>
                                    </div>
                                    <div className="col-xs-6">
                                        <div className="col-xs-4 control-label">
                                            <label>新闻来源URL</label>
                                        </div>
                                        <div className="col-xs-8">
                                            <input type="text" className="form-control"
                                                   value={this.state.content.sourceURL}
                                                   onChange={this.handleChange.bind(null, 'sourceURL')}/>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div className="row form-group form-horizontal">
                                <div className="col-xs-6">
                                    <div className="col-xs-4 control-label">
                                        <label>备注</label>
                                    </div>
                                    <div className="col-xs-8">
                                        <textarea cols="20" rows="5" className="form-control"
                                                  value={this.state.content.remarks}
                                                  onChange={this.handleChange.bind(null, 'remarks')}></textarea>
                                    </div>
                                </div>
                                <div className="col-xs-6">
                                    <div className="col-xs-4 control-label">
                                        <label>MetaDescription</label>
                                    </div>
                                    <div className="col-xs-8">
                                        <textarea cols="20" rows="5" className="form-control"
                                                  value={this.state.content.metaDescription}
                                                  onChange={this.handleChange.bind(null, 'metaDescription')}></textarea>
                                    </div>
                                </div>
                            </div>

                            <div className="row form-group form-horizontal">
                                <div className="col-xs-6">
                                    <div className="col-xs-4 control-label">
                                        <label>MetaTitle</label>
                                    </div>
                                    <div className="col-xs-8">
                                        <input type="text" className="form-control"
                                               value={this.state.content.metaTitle}
                                               onChange={this.handleChange.bind(null, 'metaTitle')}/>
                                    </div>
                                </div>
                                <div className="col-xs-6">
                                    <div className="col-xs-4 control-label">
                                        <label>MetaKeywords</label>
                                    </div>
                                    <div className="col-xs-8">
                                        <input type="text" className="form-control"
                                               value={this.state.content.metaKeywords}
                                               onChange={this.handleChange.bind(null, 'metaKeywords')}/>
                                    </div>
                                </div>
                            </div>

                            <div className="text-center">
                                <button className="btn btn-primary" type="button" onClick={this.handleSave}>保&nbsp;存
                                </button>
                                &nbsp;
                                <button className="btn btn-danger" type="button">重&nbsp;置</button>
                            </div>
                        </div>
                    </div>
                </div>
                <Footer/>
            </div>
        );
    }
});

ReactDOM.render(
    <Content />,
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