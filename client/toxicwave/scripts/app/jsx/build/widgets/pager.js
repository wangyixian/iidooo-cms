/**
 * Created by Ethan on 16/5/25.
 */

var Pager = React.createClass({displayName: "Pager",
    getInitialState: function () {
        return {
            currentPage: 1
        };
    },

    handleMove: function (pageNumber) {
        console.log(pageNumber);
        if(pageNumber > 0 && pageNumber <= this.props.pageSum) {
            this.state.currentPage = pageNumber;
            this.props.callbackParent(this.state);
        }
    },

    handleJump: function () {
        if(this.refs.inputToPage.value > 0 && this.refs.inputToPage.value <= this.props.pageSum){
            this.state.currentPage = this.refs.inputToPage.value;
            this.props.callbackParent(this.state);

        }
    },

    render: function () {
        return (
            React.createElement("div", {className: "row"}, 
                React.createElement("div", {className: "col-md-4"}), 
                React.createElement("div", {className: "col-md-4"}, 
                    React.createElement("nav", {className: "text-center"}, 
                        React.createElement("ul", {className: "pagination"}, 
                            React.createElement("li", null, React.createElement("a", {href: "javascript:void(0)", onClick: this.handleMove.bind(null, (1))}, "首页")), 
                            React.createElement("li", null, React.createElement("a", {href: "javascript:void(0)", onClick: this.handleMove.bind(null, (this.props.currentPage - 1))}, "前一页")), 
                            React.createElement("li", null, React.createElement("a", {href: "javascript:void(0)", onClick: this.handleMove.bind(null, (this.props.currentPage + 1))}, "后一页")), 
                            React.createElement("li", null, React.createElement("a", {href: "javascript:void(0)", onClick: this.handleMove.bind(null, (this.props.pageSum))}, "末页"))
                        )
                    )
                ), 
                React.createElement("div", {className: "col-md-4"}, 
                    React.createElement("nav", {className: "text-right"}, 
                        React.createElement("ul", {className: "pagination"}, 
                            React.createElement("li", null, this.props.currentPage, "/", this.props.pageSum, "页 ", this.props.recordSum, "件 "), 
                            React.createElement("li", null, "第 ", React.createElement("input", {ref: "inputToPage", type: "text", style: {width: + 40 + 'px'}}), " ", React.createElement("label", null, "页"), " ", 
                                React.createElement("button", {onClick: this.handleJump}, "跳转")
                            )
                        )
                    )
                )
            )
        );
    }
});