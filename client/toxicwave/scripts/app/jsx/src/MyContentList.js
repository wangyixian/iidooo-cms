/**
 * Created by Ethan on 16/5/31.
 */

var Actions = Reflux.createActions(['search']);

var Store = Reflux.createStore({
    listenables: [Actions],
    onSearch: function (data) {

        var url = URL.server + API.searchContentList;
        data.appID = SecurityClient.appID;
        data.secret = SecurityClient.secret;
        data.accessToken = sessionStorage.getItem(SessionKey.accessToken);
        data.userID = sessionStorage.getItem(SessionKey.userID);

        // 检查token是否过期
        if (data.accessToken == null || data.accessToken == "" || data.userID == null || data.userID == "") {
            location.href = Page.login;
            return false;
        }

        data.sortField = "CreateTime";
        data.channelID = 1;
        data.pageSize = 10;
        data.contentType = "2";

        var self = this;

        var callback = function (result) {
            if (result.status == 200) {
                self.trigger(result.data);
            } else {
                console.log(result);
            }
        };

        ajaxPost(url, data, callback);
    },
});

var ContentList = React.createClass({
    render: function () {
        return (
            <div>
                <div className="list-group">
                    {this.props.contentListData.contentList.map(function (item) {
                        return <ContentSummary key={item.contentID} content={item}/>
                    })}
                </div>
            </div>
        );
    }
});

var ContentSummary = React.createClass({
    render: function () {
        return (
            <a href="#" className="list-group-item">
                <h4 className="list-group-item-heading">{this.props.content.contentTitle}</h4>
                <p className="list-group-item-text">{this.props.content.contentSummary}</p>
                <div className="text-right">
                    <span className="margin-right-10">{new Date(this.props.content.createTime).format('yyyy-MM-dd hh:mm:ss')}</span>
                    <span className="margin-right-10">阅读({this.props.content.pageViewCount})</span>
                    <span className="margin-right-10">{ContentStatusMap[this.props.content.status]}</span>
                </div>
            </a>
        );
    }
});

var MyContentListPage = React.createClass({
    mixins: [Reflux.connect(Store, 'contentListData')],
    getInitialState: function () {
        return {
            contentListData: {
                page: {},
                contentList: []
            }
        };
    },
    componentWillMount: function () {
        Actions.search(this.state);
    },
    onChildChanged: function (childState) {
        if (childState.currentPage != null) {
            var data = {};
            data.currentPage = childState.currentPage;
            Actions.search(data);
        }
    },
    render: function () {
        return (
            <div>
                <Header activeMenuID={"menuMyContentList"}/>

                <div className="container">
                    <div className="row">
                        <div className="col-sm-3">
                            <UserInfo user={securityUser}/>
                        </div>
                        <div className="col-sm-9">
                            <ContentList contentListData={this.state.contentListData}/>
                            <Pager callbackParent={this.onChildChanged}
                                   recordSum={this.state.contentListData.page.recordSum}
                                   currentPage={this.state.contentListData.page.currentPage}
                                   pageSum={this.state.contentListData.page.pageSum}/>
                        </div>
                    </div>
                </div>

                <Footer/>
            </div>
        );
    }
});

var UserInfo = React.createClass({
    render: function () {
        return (
            <div>
                <div className="panel panel-default">
                    <div className="panel-heading">
                        <h3 className="panel-title">个人资料</h3>
                    </div>
                    <div className="panel-body">
                        <ul className="list-group">
                            <li className="list-group-item">
                                <img src={this.props.user.photoURL} className="img-square-200"/>
                            </li>
                            <li className="list-group-item">姓名：{this.props.user.userName}</li>
                            <li className="list-group-item">邮箱：{this.props.user.email}</li>
                            <li className="list-group-item">经验：{this.props.user.experience}</li>
                            <li className="list-group-item">等级：{this.props.user.level}</li>
                            <li className="list-group-item">积分：{this.props.user.points}</li>
                        </ul>
                    </div>
                </div>
            </div>
        );
    }
});

ReactDOM.render(
    <MyContentListPage />,
    document.getElementById('page')
);