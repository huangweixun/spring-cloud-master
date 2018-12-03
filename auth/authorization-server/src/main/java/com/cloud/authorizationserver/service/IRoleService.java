package com.cloud.authorizationserver.service;

import com.cloud.authorizationserver.entity.Role;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface IRoleService {

    Set<Role> queryUserRolesByUserId(long userId);

}
