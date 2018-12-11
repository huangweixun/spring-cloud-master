package com.cloud.rabbitmq.api.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;


/**
 * confirm消息确认机制
 * 消息的确认是指生产者投递消息后，如果Broker接收到消息，则会给生产者一个应答。
 * 生产者进行接收应答，用来确认这条消息是否正常的发送到Broker，这种方式也是消息可靠性投递的核心保障
 */
public class Producer2 {
    // 定义队列名字
    private final static String QUEUE_NAME = "hello";
    //定义交换机名称
    private final static String exchangeName = "test_confirm_exchange";
    //定义路由键名称
    private final static String routingKey = "confirm.save";

    public static void main(String[] argv) throws Exception {
        // 创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("134.175.52.58");
        factory.setPort(5672);
        factory.setVirtualHost("/root");
        factory.setPassword("root");
        factory.setUsername("root");
        // 创建连接、信道
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //指定消息投递模式：消息确认模式
        channel.confirmSelect();
        // 定义消息内容
        String message = "Hello World!";
        // 通过信道发布内容
        channel.basicPublish(exchangeName, routingKey, null, message.getBytes());
        channel.addConfirmListener(new ConfirmListener() {
            @Override
            public void handleAck(long l, boolean b) throws IOException {
                System.out.println("===========ACK==============");

            }

            @Override
            public void handleNack(long l, boolean b) throws IOException {
                System.out.println("===========NACK==============");

            }
        });
        System.out.println(" [x] Sent '" + message + "'");
    }

}
