/**
 * Created by Ethan on 16/5/25.
 */

var Pager = React.createClass({
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
            <div className="row">
                <div className="col-md-4"></div>
                <div className="col-md-4">
                    <nav className="text-center">
                        <ul className="pagination">
                            <li><a href="javascript:void(0)" onClick={this.handleMove.bind(null, (1))}>首页</a></li>
                            <li><a href="javascript:void(0)" onClick={this.handleMove.bind(null, (this.props.currentPage - 1))}>前一页</a></li>
                            <li><a href="javascript:void(0)" onClick={this.handleMove.bind(null, (this.props.currentPage + 1))}>后一页</a></li>
                            <li><a href="javascript:void(0)" onClick={this.handleMove.bind(null, (this.props.pageSum))}>末页</a></li>
                        </ul>
                    </nav>
                </div>
                <div className="col-md-4">
                    <nav className="text-right">
                        <ul className="pagination">
                            <li>{this.props.currentPage}/{this.props.pageSum}页&nbsp;{this.props.recordSum}件&nbsp;</li>
                            <li>第&nbsp;<input ref="inputToPage" type="text" style={{width: + 40 + 'px'}}/>&nbsp;<label>页</label>&nbsp;
                                <button onClick={this.handleJump}>跳转</button>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        );
    }
});