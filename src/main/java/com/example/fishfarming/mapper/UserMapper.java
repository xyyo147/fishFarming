package com.example.fishfarming.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.fishfarming.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
