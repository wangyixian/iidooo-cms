/**
 * Created by Ethan on 16/5/27.
 */
var MessageBox = React.createClass({displayName: "MessageBox",
    render: function () {
        return (
            React.createElement("div", {id: "messageBox", style: {display: 'none'}}, this.props.message)
        );
    }
});