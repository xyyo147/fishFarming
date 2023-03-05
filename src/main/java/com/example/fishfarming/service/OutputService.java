package com.example.fishfarming.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.fishfarming.common.Result;
import com.example.fishfarming.entity.Output;


public interface OutputService extends IService<Output> {
    public Result findData(Long userid);
    public Result remove(String name);
    public Long search(Output dead);
}

