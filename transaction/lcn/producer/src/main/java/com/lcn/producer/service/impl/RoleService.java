package com.lcn.producer.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.lcn.producer.dao.RoleMapper;
import com.lcn.producer.entity.po.Role;
import com.lcn.producer.service.IRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RoleService implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    @LcnTransaction
    public void add(Role role) {
        log.info("调用RoleService.add");
        roleMapper.insert(role);
    }
}
