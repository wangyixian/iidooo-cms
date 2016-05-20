/**
 * Created by Ethan on 16/5/13.
 */
var Footer = React.createClass({
    render: function () {
        return (
            <footer className="footer">
                <div className="container">
                    <p className="text-muted text-center">Powered by 上海轶度网络科技有限公司</p>
                    <p className="text-muted text-center">version 0.1.10.0 B20160513</p>
                </div>
            </footer>
        );
    }
});

ReactDOM.render(
    <Footer />,
    document.getElementById('footer')
);