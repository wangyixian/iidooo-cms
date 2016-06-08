/**
 * Created by Ethan on 16/5/31.
 */

var PageActions = Reflux.createActions(['search']);

var PageStore = Reflux.createStore({
    listenables: [PageActions],
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
            <div className="contentList">
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
        var editLink;
        if (this.props.content.status != ContentStatus.APPROVED && this.props.content.status != ContentStatus.PUBLISHED) {
            editLink = <EditLink contentID={this.props.content.contentID}/>;
        } else {
            editLink = <ReadLink contentID={this.props.content.contentID}/>;
        }

        // 显示副标题或者摘要
        var subTitle = this.props.content.contentSubTitle;
        if (subTitle == "") {
            subTitle = this.props.content.contentSummary;
        }

        return (
            <div className="list-group-item">
                <h4 className="list-group-item-heading">{this.props.content.contentTitle}</h4>

                <div className="list-group-item-text">{subTitle}</div>

                <div className="text-right">
                    <span className="margin-right-10">阅读({this.props.content.pageViewCount})</span>
                    <span
                        className="margin-right-10">{new Date(this.props.content.createTime).format('yyyy-MM-dd hh:mm:ss')}</span>
                    <span className="margin-right-10">{ContentStatusMap[this.props.content.status]}</span>
                    {editLink}
                </div>
            </div>
        );
    }
});

var EditLink = React.createClass({

    handleClick: function () {
        sessionStorage.setItem(SessionKey.pageMode, 2);
        sessionStorage.setItem(SessionKey.contentID, this.props.contentID);
        location.href = Page.contentNews;
    },

    render: function () {
        return (
            <a href="javascript:void(0)" onClick={this.handleClick}>
            <span className="margin-right-10">编辑
            </span></a>
        );
    }
});

var ReadLink = React.createClass({
    render: function () {
        return (
            <span className="margin-right-10">
            <a href={URL.server + API.content + "/"+this.props.contentID} target="_blank">预览</a>
            </span>
        );
    }
});

var MyContentList = React.createClass({
    mixins: [Reflux.connect(PageStore, 'contentListData')],
    getInitialState: function () {
        return {
            contentListData: {
                page: {},
                contentList: []
            }
        };
    },
    componentWillMount: function () {
        PageActions.search(this.state);
    },
    onChildChanged: function (childState) {
        if (childState.currentPage != null) {
            var data = {};
            data.currentPage = childState.currentPage;
            PageActions.search(data);
        }
    },
    render: function () {
        var user = JSON.parse(sessionStorage.getItem(SessionKey.user));
        return (
            <div>
                <Header activeMenuID={"menuMyContentList"}/>

                <div className="container">
                    <div className="row">
                        <div className="col-sm-3 user-info-wrap">
                            <UserInfo user={user}/>
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
            <div className="panel panel-default">
                <div className="panel-heading">
                    <h3 className="panel-title">个人资料</h3>
                </div>
                <div className="panel-body">
                    <ul className="list-group">
                        <li className="list-group-item">
                            <img src={this.props.user.photoURL} className="img-square-200"/>
                        </li>
                        <li className="list-group-item"><span className="inline-block">昵称：</span><span className="break-word">{this.props.user.userName}</span></li>
                        <li className="list-group-item"><span className="inline-block">邮箱：</span><span className="break-word">{this.props.user.email}</span></li>
                        <li className="list-group-item"><span className="inline-block">等级：</span><span className="break-word">{this.props.user.level}</span></li>
                    </ul>
                </div>
            </div>
        );
    }
});

ReactDOM.render(
    <MyContentList />,
    document.getElementById('page')
);