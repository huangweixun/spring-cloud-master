package com.lcn.consumer.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lcn.consumer.entity.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper extends BaseMapper<User> {
}
