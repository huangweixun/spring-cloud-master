package com.lcn.consumer.service.impl;

import com.cloud.core.exception.BaseException;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.lcn.consumer.dao.UserMapper;
import com.lcn.consumer.entity.po.User;
import com.lcn.consumer.entity.vo.RoleAddForm;
import com.lcn.consumer.manager.ProducerService;
import com.lcn.consumer.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService implements IUserService {

    @Autowired
    private ProducerService producerService;

    @Autowired
    private UserMapper userMapper;

    @Override
    @LcnTransaction
    public void add(User user) {
        log.info("调用UserService.add");
        RoleAddForm roleAddForm = RoleAddForm.builder().code("ROLE_ADD").description("添加权限").name("添加").build();
        producerService.add(roleAddForm);

        userMapper.insert(user);
    }
}
