package com.ansen.service;

import com.ansen.util.RabbitmqConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * @Desc
 * @Auhtor caomx
 * @Date 2021-09-17
 * @Version
 */
public class SendMessage {
    private final static String  QUEUE_NAME="simp_queue";
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitmqConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        String message = "hello world";
        channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
        System.out.println("send message is:"+message);
        channel.close();
        connection.close();

    }
}
