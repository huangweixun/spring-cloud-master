package com.lcn.consumer.controller;

import com.cloud.core.entity.vo.Result;
import com.lcn.consumer.entity.form.UserAddForm;
import com.lcn.consumer.entity.po.User;
import com.lcn.consumer.service.impl.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("add")
    public Result add(@Valid @RequestBody UserAddForm userAddForm) {
        log.info("name:{}", userAddForm);
        userService.add(userAddForm.toPo(User.class));
        return Result.success();
    }
}
