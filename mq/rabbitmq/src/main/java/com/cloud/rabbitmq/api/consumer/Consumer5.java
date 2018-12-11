package com.cloud.rabbitmq.api.consumer;

import com.rabbitmq.client.*;

/**
 * confirm消息确认机制
 * 消息的确认是指生产者投递消息后，如果Broker接收到消息，则会给生产者一个应答。
 * 生产者进行接收应答，用来确认这条消息是否正常的发送到Broker，这种方式也是消息可靠性投递的核心保障
 */
public class Consumer5 {
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception {
        // 创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("134.175.52.58");
        factory.setPort(5672);
        factory.setVirtualHost("/root");
        factory.setPassword("root");
        factory.setUsername("root");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.basicQos(0,1,false);
        //申明队列
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
            System.out.println(System.currentTimeMillis());
            channel.basicNack(delivery.getEnvelope().getDeliveryTag(),false,true);
        };
        //回调 队列名、是否自动确认信息、回调
        channel.basicConsume(QUEUE_NAME, false, deliverCallback, consumerTag -> { });

    }

}
