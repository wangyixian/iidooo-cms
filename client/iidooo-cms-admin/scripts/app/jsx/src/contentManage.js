/**
 * Created by Ethan on 16/5/18.
 */

var ContentManageActions = Reflux.createActions(['search']);

var ContentManageStore = Reflux.createStore({
    listenables: [ContentManageActions],
    onSearch: function (data) {
        var url = serverURL + searchContentListURL;
        data.appID = appID;
        data.secret = secret;
        data.accessToken = $.cookie("ACCESS_TOKEN");
        // 检查token是否过期
        if (data.accessToken == null || data.accessToken == "") {
            alert("登陆过期，请重新登陆！");
            location.href = clientURL + loginPage;
            return false;
        }

        var self = this;
        var channelMap = data.channelMap;
        var contentTypeMap = data.contentTypeMap;
        var contentStatusMap = data.contentStatusMap;
        var callback = function (result) {
            if (result.status == 200) {
                // 从后台取到的都是ID，此处设置一些显示值
                for (var i = 0; i < result.data.length; i++) {
                    var content = result.data[i];
                    content.channelName = channelMap[content.channelID];
                    content.contentTypeName = contentTypeMap[content.contentType];
                    content.statusName = contentStatusMap[content.status];
                }
                self.trigger(result.data);
            } else {
                console.log(result);
                alert("获取登陆用户信息失败！");
            }
        };

        ajaxPost(url, data, callback);
    }
});

var ContentManage = React.createClass({
    mixins: [Reflux.connect(ContentManageStore, 'contentList')],
    getInitialState: function () {
        return {
            channelID: 0,
            contentTitle: "",
            contentType: 0,
            startDate: "",
            endDate: "",
            status: 0,
            contentList: [],
            channelMap: {},
            contentTypeMap: {},
            contentStatusMap: {}
        };
    },
    onStatusChange: function (contentList) {
        this.state.contentList = contentList;
    },
    handleSearch: function () {
        this.state.contentTitle = this.refs.inputContentTitle.value;
        this.state.startDate = this.refs.inputStartDate.value;
        this.state.endDate = this.refs.inputEndDate.value;
        ContentManageActions.search(this.state);
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
            this.state.contentStatusMap = childState.contentStatusMap;
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
                                    <ChannelList ref="channelList" channelID={this.state.channelID} callbackParent={this.onChildChanged}/>
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
                                    <ContentTypeList contentType={this.state.contentType} callbackParent={this.onChildChanged}/>
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
                                                       callbackParent={this.onChildChanged}/>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div className="text-right">
                        <button id="btnSearch" className="btn btn-primary" type="button" onClick={this.handleSearch}>
                            查&nbsp;询
                        </button>
                        &nbsp;
                        <button id="btnCreate" className="btn btn-success" type="button">发&nbsp;布</button>
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
                        {this.state.contentList.map(function (item) {
                            return <ContentList key={item.contentID} content={item}/>
                        })}
                        </tbody>
                    </table>
                    <nav className="text-center">
                        <ul className="pagination">
                            <li>
                                <a href="#" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <li className="active"><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#">5</a></li>
                            <li>
                                <a href="#" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        );
    }
});

var ContentList = React.createClass({
    render: function () {
        return (
            <tr>
                <td>{this.props.content.contentID}</td>
                <td>{this.props.content.channelName}</td>
                <td>{this.props.content.contentTitle}</td>
                <td>{this.props.content.stickyIndex}</td>
                <td>{this.props.content.contentTypeName}</td>
                <td>{this.props.content.statusName}</td>
                <td>{this.props.content.createUser.userName}</td>
                <td>{new Date(this.props.content.createTime).format('yyyy-MM-dd hh:mm:ss')}</td>
                <td>{this.props.content.pageViewCount}</td>
                <td>
                    <a id='btnModify' href='#'>修改</a> |
                    <a id='btnDelete' href='#'>删除</a> |
                    <a id='btnSticky' href='#'>置顶</a>
                </td>
            </tr>
        );
    }
});

ReactDOM.render(
    <ContentManage />,
    document.getElementById('contentManage')
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