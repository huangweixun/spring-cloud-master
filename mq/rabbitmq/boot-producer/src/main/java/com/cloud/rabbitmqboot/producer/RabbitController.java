package com.cloud.rabbitmqboot.producer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class RabbitController {

    @Autowired
    private RabbitSender rabbitSender;

    @GetMapping("/send")
    public void sendMsg() throws Exception {
        String msg = "测试消息传输";
        rabbitSender.send(msg, new HashMap<>());
    }

}
