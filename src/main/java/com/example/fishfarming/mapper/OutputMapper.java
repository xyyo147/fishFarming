package com.example.fishfarming.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.fishfarming.entity.Input;
import com.example.fishfarming.entity.Output;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OutputMapper extends BaseMapper<Output> {
}
