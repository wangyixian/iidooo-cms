/**
 * Created by Ethan on 16/5/27.
 */
var Message = React.createClass({displayName: "Message",
    render: function () {
        return (
            React.createElement("div", {id: "messageBox", style: {display: 'none'}}, this.props.message)
        );
    }
});