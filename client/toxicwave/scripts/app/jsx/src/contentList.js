/**
 * Created by Ethan on 16/5/18.
 */

var ContentListActions = Reflux.createActions(['search', 'delete', 'updateContent']);

var ContentListStore = Reflux.createStore({
    listenables: [ContentListActions],
    searchCondition: {},
    contentListData: {
        page: {},
        contentList: []
    },
    onSearch: function (data) {
        var url = API.searchContentList;
        data.appID = SecurityClient.appID;
        data.secret = SecurityClient.secret;
        data.accessToken = sessionStorage.getItem(SessionKey.accessToken);
        // 检查token是否过期
        if (data.accessToken == null || data.accessToken == "") {
            location.href = Page.login;
            return false;
        }

        data.sortField = "CreateTime";

        var self = this;
        var channelMap = data.channelMap;
        var contentTypeMap = data.contentTypeMap;

        // 保存查询条件
        searchCondition = data;

        var callback = function (result) {
            if (result.status == 200) {
                // 从后台取到的都是ID，此处设置一些显示值
                for (var i = 0; i < result.data.contentList.length; i++) {
                    var content = result.data.contentList[i];
                    content.channelName = channelMap[content.channelID];
                    content.contentTypeName = contentTypeMap[content.contentType];
                }

                // 保存起来做即时处理
                contentListData = result.data;
                self.trigger(result.data);
            } else {
                console.log(result);
                alert("获取登陆用户信息失败！");
            }
        };

        ajaxPost(url, data, callback);
    },
    onDelete: function (data) {
        var url = API.deleteContent;
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
                //$.each(contentList, function (index, object) {
                //    if (data.contentID == object.contentID) {
                //        contentList.splice(index, 1);//从下标为i的元素开始，连续删除1个元素
                //        return false;
                //    }
                //});
                //self.trigger(contentList);
                ContentListActions.search(searchCondition);
            } else {
                console.log(result);
                alert("获取登陆用户信息失败！");
            }
        };

        ajaxPost(url, data, callback);
    },

    onUpdateContent: function (data) {
        var url = API.updateContent;
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
                $.each(contentListData.contentList, function (index, object) {
                    if (data.contentID == object.contentID) {
                        object = result.data;
                        return false;
                    }
                });
                self.trigger(contentListData);
            } else {
                console.log(result);
                alert("内容更新失败！");
            }
        };

        ajaxPost(url, data, callback);
    },
});

var ContentList = React.createClass({
    mixins: [Reflux.connect(ContentListStore, 'contentListData')],
    getInitialState: function () {
        return {
            channelID: 0,
            contentTitle: "",
            contentType: "0",
            startDate: "",
            endDate: "",
            status: "",
            contentListData: {
                page: {},
                contentList: []
            },
            channelMap: {},
            contentTypeMap: {}
        };
    },
    handleSearch: function () {
        this.state.contentTitle = this.refs.inputContentTitle.value;
        this.state.startDate = this.refs.inputStartDate.value;
        this.state.endDate = this.refs.inputEndDate.value;
        ContentListActions.search(this.state);
    },
    onChildChanged: function (childState) {
        if (childState.channelID != null) {
            this.state.channelID = childState.channelID;
        }
        if (childState.contentType != null) {
            this.state.contentType = childState.contentType;
        }
        if (childState.contentStatus != null) {
            this.state.status = childState.contentStatus;
        }
        if (childState.channelMap != null) {
            this.state.channelMap = childState.channelMap;
        }
        if (childState.contentTypeMap != null) {
            this.state.contentTypeMap = childState.contentTypeMap;
        }
        if (childState.contentStatusMap != null) {
            ContentStatusMap = childState.contentStatusMap;
        }
        if (childState.currentPage != null) {
            searchCondition.currentPage = childState.currentPage;
            ContentListActions.search(searchCondition);
        }
    },
    render: function () {
        return (
            <div>
                <div className="search-condition-section">
                    <div className="form-horizontal">
                        <div className="row form-group">
                            <div className="col-xs-4">
                                <div className="col-xs-4 control-label">
                                    <label htmlFor="channelList">所属栏目</label>
                                </div>
                                <div className="col-xs-8">
                                    <ChannelList ref="channelList" channelID={this.state.channelID}
                                                 callbackParent={this.onChildChanged} isContainAll="true"/>
                                </div>
                            </div>
                            <div className="col-xs-4">
                                <div className="col-xs-4 control-label">
                                    <label>内容标题</label>
                                </div>
                                <div className="col-xs-8">
                                    <input type="text" className="form-control" ref="inputContentTitle"/>
                                </div>
                            </div>
                            <div className="col-xs-4">
                                <div className="col-xs-4 control-label">
                                    <label>内容类型</label>
                                </div>
                                <div className="col-xs-8">
                                    <ContentTypeList contentType={this.state.contentType}
                                                     callbackParent={this.onChildChanged} isContainAll="true"/>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div className="form-horizontal">
                        <div className="row form-group">
                            <div className="col-xs-4">
                                <div className="col-xs-4 control-label">
                                    <label>发布开始日</label>
                                </div>
                                <div className="col-xs-8">
                                    <div className="input-group date form_date" data-date=""
                                         data-date-format="yyyy-mm-dd"
                                         data-link-field="startDate" data-link-format="yyyy-mm-dd">
                                        <input id="startDate" className="form-control" type="text" ref="inputStartDate"
                                               readonly/>
                                        <span className="input-group-addon">
                                            <span className="glyphicon glyphicon-calendar"></span>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div className="col-xs-4">
                                <div className="col-xs-4 control-label">
                                    <label>发布结束日</label>
                                </div>
                                <div className="col-xs-8">
                                    <div className="input-group date form_date" data-date=""
                                         data-date-format="yyyy-mm-dd"
                                         data-link-field="endDate" data-link-format="yyyy-mm-dd">
                                        <input id="endDate" className="form-control" type="text" ref="inputEndDate"
                                               readonly/>
                                        <span className="input-group-addon">
                                            <span className="glyphicon glyphicon-calendar"></span>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div className="col-xs-4">
                                <div className="col-xs-4 control-label">
                                    <label>内容状态</label>
                                </div>
                                <div className="col-xs-8">
                                    <ContentStatusList contentStatus={this.state.status}
                                                       callbackParent={this.onChildChanged} isContainAll="true"/>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div className="text-right">
                        <a href="javascript:void(0)" className="btn btn-primary" onClick={this.handleSearch}>
                            查&nbsp;询
                        </a>
                        &nbsp;
                        <a className="btn btn-success" href={clientURL + contentDetailPage + "?pageMode=1"}
                           target="_blank">发&nbsp;布</a>
                    </div>
                </div>
                <div className="search-result-section">
                    <table className="table table-striped table-hover">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>栏目</th>
                            <th>标题</th>
                            <th>置顶级别</th>
                            <th>类型</th>
                            <th>状态</th>
                            <th>发布者</th>
                            <th>发布时间</th>
                            <th>PV</th>
                            <th>快捷操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        {this.state.contentListData.contentList.map(function (item) {
                            return <ContentSearchResult key={item.contentID} content={item}/>
                        })}
                        </tbody>
                    </table>
                    <Pager callbackParent={this.onChildChanged}
                           recordSum={this.state.contentListData.page.recordSum}
                           currentPage={this.state.contentListData.page.currentPage}
                           pageSum={this.state.contentListData.page.pageSum}/>
                </div>
            </div>
        );
    }
});

var ContentSearchResult = React.createClass({
    getInitialState: function () {
        return {
            contentDetailURL: clientURL + contentDetailPage + "?pageMode=2&contentID=" + this.props.content.contentID
        };
    },

    handleDelete: function (content) {
        if ($.inArray(API.deleteContent, securityUser.resUrlList) < 0 || dataPermission(null, content)) {
            alert(Message.NO_PERMISSION);
            return false;
        }
        if (window.confirm('确定要删除吗？')) {
            ContentListActions.delete(content);
        }
    },

    handleSticky: function (content) {
        if ($.inArray(API.updateContent, securityUser.resUrlList) < 0 ||
            securityUser.roleCode == role.editor) {
            alert(Message.NO_PERMISSION);
            return false;
        }
        content.stickyIndex = content.stickyIndex + 1;
        ContentListActions.updateContent(content);
    },

    handlePublish: function (content) {
        if ($.inArray(API.updateContent, securityUser.resUrlList) < 0 ||
            securityUser.roleCode == role.editor) {
            alert(Message.NO_PERMISSION);
            return false;
        }
        content.status = 0;
        ContentListActions.updateContent(content);
    },

    render: function () {
        var userName = "";
        if(this.props.content.createUser != null){
            userName = this.props.content.createUser.userName;
        }
        return (
            <tr>
                <td>{this.props.content.contentID}</td>
                <td>{this.props.content.channelName}</td>
                <td>{this.props.content.contentTitle}</td>
                <td>{this.props.content.stickyIndex}</td>
                <td>{this.props.content.contentTypeName}</td>
                <td>{ContentStatusMap[this.props.content.status]}</td>
                <td>{userName}</td>
                <td>{new Date(this.props.content.createTime).format('yyyy-MM-dd hh:mm:ss')}</td>
                <td>{this.props.content.pageViewCount}</td>
                <td>
                    <a href={this.state.contentDetailURL} target="_blank">详细</a> |
                    <a href="javascript:void(0)" onClick={this.handleDelete.bind(null, this.props.content)}>删除</a> |
                    <a href="javascript:void(0)" onClick={this.handleSticky.bind(null, this.props.content)}>置顶</a> |
                    <a href="javascript:void(0)" onClick={this.handlePublish.bind(null, this.props.content)}>发布</a>
                </td>
            </tr>
        );
    }
});

ReactDOM.render(
    <ContentList />,
    document.getElementById('contentList')
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
});