package com.example.fishfarming.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.fishfarming.common.Result;
import com.example.fishfarming.entity.WaterQuality;



public interface WaterQualityService extends IService<WaterQuality> {
    public Result findData(Long userid);
    public Result remove(Long id);
    public Long search(WaterQuality waterQuality);
}

