/**
 * Created by Ethan on 16/5/20.
 */
var Breadcrumb = React.createClass({displayName: "Breadcrumb",
    getInitialState: function () {
        return {
            indexPageURL: Page.contentList,
            contentListPageURL: Page.contentList
        };
    },
    render: function () {
        return (
            React.createElement("ol", {className: "breadcrumb"}, 
                React.createElement("li", null, React.createElement("a", {href: this.state.indexPageURL}, "首页")), 
                React.createElement("li", null, React.createElement("a", {href: this.state.contentListPageURL}, "内容管理")), 
                React.createElement("li", {className: "active"}, "内容发布")
            )
        );
    }
});