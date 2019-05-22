package com.lcn.producer.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lcn.producer.entity.po.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface RoleMapper extends BaseMapper<Role> {
}
