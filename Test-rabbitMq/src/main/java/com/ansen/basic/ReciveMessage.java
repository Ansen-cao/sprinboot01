package com.ansen.service;

import com.ansen.util.RabbitmqConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Desc
 * @Auhtor caomx
 * @Date 2021-09-17
 * @Version
 */
public class ReciveMessage {
    private final static String QUEUE_NAME = "simp_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitmqConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String exchange = envelope.getExchange();
                long deliveryTag = envelope.getDeliveryTag();
                String msg = new String(body,"utf-8");
                System.out.println("recive message is:"+msg);
            }
        };
        channel.basicConsume(QUEUE_NAME,true,defaultConsumer);
    }
}
