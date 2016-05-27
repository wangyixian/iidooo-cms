/**
 * Created by Ethan on 16/5/18.
 */

var ChannelListActions = Reflux.createActions(['getChannelList']);

var ChannelListStore = Reflux.createStore({
    listenables: [ChannelListActions],

    onGetChannelList: function (data) {
        var url = URL.server + API.getChannelList;
        data.appID = SecurityClient.appID;
        data.secret = SecurityClient.secret;
        data.accessToken = sessionStorage.getItem(SessionKey.accessToken);

        // 检查token是否过期
        if (data.accessToken == null || data.accessToken == "") {
            location.href = Page.login;
            return false;
        }

        var self = this;
        var callback = function (result) {
            if (result.status == 200) {
                self.trigger(result.data);
            } else {
                console.log(result);
                alert("获取栏目列表信息失败！");
            }
        };

        ajaxPost(url, data, callback);
    }
});

var ChannelList = React.createClass({displayName: "ChannelList",
    mixins: [Reflux.connect(ChannelListStore, 'channelList')],
    getInitialState: function () {
        return {
            channelID: this.props.channelID,
            channelList: [],
            channelMap:{}
        };
    },
    componentWillMount: function () {
        ChannelListActions.getChannelList(this.state);
    },
    componentDidUpdate: function () {
        for (var i = 0; i < this.state.channelList.length; i++) {
            var channel = this.state.channelList[i];
            // 记录到channelMap
            this.state.channelMap[channel.channelID] = channel.channelName;
        }
        this.state.channelID = this.refs.inputChannelID.value;
        this.props.callbackParent(this.state);
    },
    componentWillReceiveProps: function(nextProps) {
        this.refs.inputChannelID.value = nextProps.channelID;
    },
    handleChange: function () {
        this.state.channelID = this.refs.inputChannelID.value;
        // 这里要注意：setState 是一个异步方法，所以需要操作缓存的当前值
        this.props.callbackParent(this.state);
    },
    checkIsContainAll: function(){
        if(this.props.isContainAll == 'true') {
            return (
                React.createElement("option", {value: "0"}, "全部")
            );
        }
    },
    render: function () {
        return (
                React.createElement("select", {className: "form-control", defaultValue: this.props.channelID, ref: "inputChannelID", onChange: this.handleChange}, 
                    this.checkIsContainAll(), 
                    this.state.channelList.map(function (item) {
                        return React.createElement("option", {key: item.channelID, value: item.channelID}, item.channelName)
                    })
                )

        );
    }
});