package com.lcn.producer.controller;

import com.cloud.core.entity.vo.Result;
import com.lcn.producer.entity.form.RoleAddForm;
import com.lcn.producer.entity.po.Role;
import com.lcn.producer.service.impl.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/role")
@Slf4j
public class RoleController {

    @Autowired
    private RoleService userService;

    @PostMapping("add")
    public Result add(@Valid @RequestBody RoleAddForm roleAddForm) {
        log.info("name:{}", roleAddForm);
        userService.add(roleAddForm.toPo(Role.class));
        return Result.success();
    }
}
