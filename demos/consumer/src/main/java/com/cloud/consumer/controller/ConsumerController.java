package com.cloud.consumer.controller;

import com.cloud.consumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hwx
 * @date 2018/12/3
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/order")
public class ConsumerController {
    @Autowired
    ConsumerService consumerService;

    @GetMapping("/test")
    public String test() {
        System.out.println("测试feign调用");
        return consumerService.test();
    }

    @GetMapping("/test2")
    public String test2() {
        System.out.println("测试feign-Hystrix调用");
        return consumerService.test2();
    }
}
