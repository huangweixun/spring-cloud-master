//package com.cloud.authorizationserver.service.impl;
//
//
//
//import com.cloud.authorizationserver.dao.RoleMapper;
//import com.cloud.authorizationserver.entity.Role;
//import com.cloud.authorizationserver.service.IRoleService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Set;
//
//@Service
//public class RoleService implements IRoleService {
//    @Autowired
//    private RoleMapper roleMapper;
//
//    @Override
//    public Set<Role> queryUserRolesByUserId(long userId) {
//        return roleMapper.queryByUserId(userId);
//    }
//
//}
