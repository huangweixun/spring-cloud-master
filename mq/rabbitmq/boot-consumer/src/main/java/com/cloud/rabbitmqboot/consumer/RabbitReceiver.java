package com.cloud.rabbitmqboot.consumer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RabbitReceiver {


    //	@RabbitListener(bindings = @QueueBinding(
//			value = @Queue(value = "test.topic.queue",
//			durable="true"),
//			exchange = @Exchange(value = "test.topic",
//			durable="true",
//			type= "topic",
//			ignoreDeclarationExceptions = "true"),
//			key = "user.#"
//			)
//	)
    @RabbitListener(queues = "redirect-queue")
    @RabbitHandler
    public void onMessage(Message message, Channel channel) throws Exception {
        System.err.println("死信队列===============================");
        System.err.println("消费端Payload: " + message.getPayload());
        Long deliveryTag = (Long) message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        //手工ACK
//		channel.basicAck(deliveryTag, false);
        channel.addConfirmListener(confirmListener);

        channel.basicNack(deliveryTag, false, false);
    }

    ConfirmListener confirmListener = new ConfirmListener() {
        @Override
        public void handleAck(long l, boolean b) throws IOException {
            System.err.println("=========handleAck============");
        }

        @Override
        public void handleNack(long l, boolean b) throws IOException {
            System.err.println("=========handleNack============");
        }
    };



}
