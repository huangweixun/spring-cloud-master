package com.cloud.rabbitmq.api.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


/**
 * confirm消息确认机制
 * 消息的确认是指生产者投递消息后，如果Broker接收到消息，则会给生产者一个应答。
 * 生产者进行接收应答，用来确认这条消息是否正常的发送到Broker，这种方式也是消息可靠性投递的核心保障
 */
public class Producer5 {
    // 定义队列名字
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws Exception {
        // 创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("134.175.52.58");
        factory.setPort(5672);
        factory.setVirtualHost("/root");
        factory.setPassword("root");
        factory.setUsername("root");
        // 创建连接、信道
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            // 声明一个队列：名称、持久性的（重启仍存在此队列）、非私有的、非自动删除的
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);
            // 定义消息内容
            String message = "Hello World!";
            // 通过信道发布内容
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }
    }

}
