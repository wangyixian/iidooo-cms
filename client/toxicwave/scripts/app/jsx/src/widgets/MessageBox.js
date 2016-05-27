/**
 * Created by Ethan on 16/5/27.
 */
var MessageBox = React.createClass({
    render: function () {
        return (
            <div id="messageBox" style={{display: 'none'}}>{this.props.message}</div>
        );
    }
});