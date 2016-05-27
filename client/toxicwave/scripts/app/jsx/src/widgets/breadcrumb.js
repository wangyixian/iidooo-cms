/**
 * Created by Ethan on 16/5/20.
 */
var Breadcrumb = React.createClass({
    getInitialState: function () {
        return {
            indexPageURL: Page.contentList,
            contentListPageURL: Page.contentList
        };
    },
    render: function () {
        return (
            <ol className="breadcrumb">
                <li><a href={this.state.indexPageURL}>首页</a></li>
                <li><a href={this.state.contentListPageURL}>内容管理</a></li>
                <li className="active">内容发布</li>
            </ol>
        );
    }
});