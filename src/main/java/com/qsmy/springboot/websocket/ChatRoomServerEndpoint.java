package com.qsmy.springboot.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import java.io.IOException;

import static com.qsmy.springboot.utils.WebSocketUtils.*;

/**
 * @author qsmy
 * @date 2019-07-09
 *
 * <pre>
 *     onOpen   :建立WebSocket连接时触发
 *     message  :客户端监听服务端事件，当服务端向客户端推送消息时会被监听到
 *     error    :WebSocket发生错误时会触发
 *     close    :关闭WebSocket连接时触发
 * </pre>
 *
 */

@Slf4j
@RestController
@ServerEndpoint("/chat-room/{username}")
public class ChatRoomServerEndpoint {

    @OnOpen
    public void openSession(@PathParam("username") String username, Session session) {
        LIVING_SESSIONS_CACHE.put(username, session);
        String message = "欢迎用户[" + username + "]来到聊天室！";
        log.info(message);
        sendMessageAll(message);
    }

    @OnMessage
    public void onMessage(@PathParam("username") String username, String message) {
        log.info(message);
        sendMessageAll("用户[" + username + "]:" + message);
    }

    @OnClose
    public void onClose(@PathParam("username") String username, Session session) {
        // 当前的session移除
        LIVING_SESSIONS_CACHE.remove(username);
        // 并且通知其他人当前用户已离开聊天室
        sendMessageAll(String.format("用户[%s]已经离开聊天室了!", username));

        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        throwable.printStackTrace();
    }

    @GetMapping("chat-room/{sender}/to/{receive}")
    public void getMessage(@PathVariable("sender") String sender,
                           @PathVariable("receive") String receive, String message) {
        sendMessage(LIVING_SESSIONS_CACHE.get(receive), String.format("[%s]->%s:%s", sender, receive, message));
    }
}
