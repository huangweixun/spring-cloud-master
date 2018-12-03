package com.cloud.authenticationserver.dao;


import com.cloud.authenticationserver.entity.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

@Mapper
public interface ResourceMapper {


    Set<Resource> findAll();


    Set<Resource> queryByRoleCodes(@Param("roleCodes") String[] roleCodes);
}