package com.cloud.authorizationserver.dao;


import com.cloud.authorizationserver.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

@Mapper
public interface RoleMapper {

    Set<Role> queryByUserId(@Param("userId") long userId);
}