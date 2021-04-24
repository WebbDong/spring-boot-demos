package com.webbdong.springboot.websocket.endpoint;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Webb Dong
 * @date 2021-04-24 12:38 PM
 */
@ServerEndpoint("/helloworld")
@Component
@Slf4j
public class HelloWorldEndpoint {

    /**
     * 记录当前在线连接数
     */
    private static AtomicInteger onlineCount = new AtomicInteger(0);

    /**
     * 连接建立成功后，调用该方法
     */
    @OnOpen
    public void onOpen(Session session) {
        onlineCount.incrementAndGet();
        log.info("有新连接加入：{}，当前在线人数为：{}", session.getId(), onlineCount.get());
    }

    /**
     * 连接关闭后，调用该方法
     */
    @OnClose
    public void onClose(Session session) {
        onlineCount.decrementAndGet();
        log.info("有一连接关闭：{}，当前在线人数为：{}", session.getId(), onlineCount.get());
    }

    /**
     * 收到客户端消息后，调用该方法
     */
    @SneakyThrows
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("服务端收到客户端[{}]的消息：{}", session.getId(), message);
        session.getBasicRemote().sendText("Hello Websocket");
    }

    /**
     * 当发生异常时，调用该方法
     */
    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

}
