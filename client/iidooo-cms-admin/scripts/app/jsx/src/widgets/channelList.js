/**
 * Created by Ethan on 16/5/18.
 */
var ChannelListActions = Reflux.createActions(['getChannelList']);

var ChannelListStore = Reflux.createStore({
    listenables: [ChannelListActions],

    onGetChannelList: function (data) {
        var url = serverURL + getChannelListURL;
        data.appID = appID;
        data.secret = secret;
        data.accessToken = $.cookie("ACCESS_TOKEN");

        // 检查token是否过期
        if (data.accessToken == null || data.accessToken == "") {
            location.href = clientURL + loginPage;
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

var ChannelList = React.createClass({
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
        this.props.callbackParent(this.state);
    },
    handleChange: function () {
        this.state.channelID = this.refs.inputChannelID.value;
        // 这里要注意：setState 是一个异步方法，所以需要操作缓存的当前值
        this.props.callbackParent(this.state);
    },
    render: function () {
        return (
            <select className="form-control" ref="inputChannelID" onChange={this.handleChange}>
                <option value="0">全部</option>
                {this.state.channelList.map(function (item) {
                    return <option key={item.channelID} value={item.channelID}>{item.channelName}</option>
                })}
            </select>
        );
    }
});