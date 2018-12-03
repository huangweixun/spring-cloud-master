package com.cloud.producer.service.impl;

import com.cloud.producer.service.ProducerService;
import org.springframework.stereotype.Service;
import rx.Producer;

/**
 * @author hwx
 * @date 2018/11/9
 */
@Service
public class ProducerServiceImpl implements ProducerService {
    @Override
    public String test() {
        return "this is Producer service";
    }
}
