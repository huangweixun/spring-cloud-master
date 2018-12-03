package com.cloud.producer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author hwx
 * @date 2018/12/3
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/producer")
public class ProducerController {
    @GetMapping("/test")
    public String test() {
        return "测试feign调用";
    }

    @GetMapping("/test2")
    public String test2() throws InterruptedException {
        Thread.sleep(20000);
        return "repertory/test2";
    }

    @GetMapping("/testHystrix")
    public String testHystrix() {
        if (new Random().nextInt(10) % 2 == 1) {
            throw new RuntimeException("服务熔断");
        }
        return "正常testHystrix";
    }


    @GetMapping("/testHystrix2")
    @HystrixCommand(fallbackMethod = "testFallback")
    public String testHystrix2() throws InterruptedException {

        Thread.sleep(2000);
        return "信号量隔离，最大并发数为10";
    }


    public String testFallback() {
        return "error";
    }
}
