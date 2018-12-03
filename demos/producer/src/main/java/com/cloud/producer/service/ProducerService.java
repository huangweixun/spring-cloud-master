package com.cloud.producer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author hwx
 * @date 2018/12/3
 */
@FeignClient(value = "producer-service")
public interface ProducerService {
    @GetMapping("test")
    String test();
}