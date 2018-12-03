package com.cloud.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author hwx
 * @date 2018/12/3
 */
@Component
@FeignClient(value = "producer-service", path = "/producer", fallback = ConsumerService.ConsumerServiceFallback.class)
public interface ConsumerService {

    @GetMapping("test")
    String test();

    @GetMapping("test2")
    String test2();

    @Component
    class ConsumerServiceFallback implements ConsumerService {
        @Override
        public String test() {
            return "OrderServiceFallback";
        }

        @Override
        public String test2() {
            System.out.println("===============");
            return "OrderServiceFallback";
        }
    }
}
