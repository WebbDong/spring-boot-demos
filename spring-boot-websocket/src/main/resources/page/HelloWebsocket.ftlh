<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0,viewport-fit=cover">
    <title>HelloWebsocket</title>
    <script type="text/javascript">
        let websocket = null;
        if ('WebSocket' in window) {
            websocket = new WebSocket('ws://localhost:20000/helloworld');
        } else {
            alert('Not support websocket');
        }

        // 连接发生错误的回调方法
        websocket.onerror = function() {
            setMessageInnerHTML("error");
        };

        // 连接成功建立的回调方法
        websocket.onopen = function(event) {
            //setMessageInnerHTML("open");
        }

        // 接收到消息的回调方法
        websocket.onmessage = function(event) {
            setMessageInnerHTML(event.data);
        }

        // 连接关闭的回调方法
        websocket.onclose = function() {
            setMessageInnerHTML("close");
        }

        // 监听窗口关闭事件，当窗口关闭时，主动去关闭 websocket 连接，防止连接还没断开就关闭窗口，server 端会抛异常。
        window.onbeforeunload = function() {
            websocket.close();
        }

        // 将消息显示在网页上
        function setMessageInnerHTML(innerHTML) {
            document.getElementById('message').innerHTML += innerHTML + '<br/>';
        }

        // 关闭连接
        function closeWebSocket() {
            websocket.close();
        }

        // 发送消息
        function send() {
            let message = document.getElementById('text').value;
            websocket.send(message);
        }
    </script>
</head>
<body>
    <input id="text" type="text" />
    <button onclick="send()">Send</button>
    <button onclick="closeWebSocket()">Close</button>
    <div id="message"></div>
</body>
<body>