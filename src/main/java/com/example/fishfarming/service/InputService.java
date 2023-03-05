package com.example.fishfarming.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.fishfarming.common.Result;
import com.example.fishfarming.entity.Input;



public interface InputService extends IService<Input> {
    public Result findData(Long userid);
    public Result remove(String name);
    public Long search(Input dead);
}

