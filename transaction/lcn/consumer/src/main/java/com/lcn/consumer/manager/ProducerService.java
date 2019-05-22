package com.lcn.consumer.manager;

import com.cloud.core.entity.vo.Result;
import com.lcn.consumer.entity.vo.RoleAddForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(name = "lcn-producer")
@RequestMapping("/role")
public interface ProducerService {

    @PostMapping(value = "/add")
    Result add(@RequestBody RoleAddForm roleAddForm);
}
