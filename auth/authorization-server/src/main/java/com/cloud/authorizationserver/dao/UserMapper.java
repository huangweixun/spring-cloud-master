package com.cloud.authorizationserver.dao;

import com.cloud.authorizationserver.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    User getByUsername(@Param("username") String username);
}