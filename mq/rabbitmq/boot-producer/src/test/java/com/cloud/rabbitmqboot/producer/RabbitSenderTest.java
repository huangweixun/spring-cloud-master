package com.cloud.rabbitmqboot.producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitSenderTest {

    @Autowired
    private RabbitSender rabbitSender;


    @Test
    public void send() throws Exception {
        String msg = "测试消息传输";
        rabbitSender.send(msg, new HashMap<>());
    }

    @Test
    public void sendOrder() {
    }
}