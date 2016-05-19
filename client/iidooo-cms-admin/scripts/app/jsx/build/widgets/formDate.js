/**
 * Created by Ethan on 16/5/19.
 */
var FormDate = React.createClass({displayName: "FormDate",

    getInitialState: function () {
        return {
            startDate: this.props.startDate,
            endDate: this.props.endDate
        };
    },
    handleInput: function () {
        if(this.props.startDate != null) {
            console.log(this.refs.date.value);
            this.state.startDate = this.refs.date.value;
        }
        if(this.props.endDate != null) {
            this.state.endDate = this.refs.date.value;
        }
        // 这里要注意：setState 是一个异步方法，所以需要操作缓存的当前值
        this.props.callbackParent(this.state);
    },
    render: function () {
        return (
            React.createElement("div", {className: "input-group date form_date", "data-date": "", "data-date-format": "yyyy-MM-dd", 
                 "data-link-format": "yyyy-MM-dd"}, 
                React.createElement("input", {className: "form-control", size: "14", type: "text", ref: "date", onInput: this.handleInput}), 
                React.createElement("span", {className: "input-group-addon"}, 
                    React.createElement("span", {className: "glyphicon glyphicon-calendar"})
                )
            )
        );
    }
});

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