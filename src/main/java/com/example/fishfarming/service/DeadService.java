package com.example.fishfarming.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.fishfarming.common.Result;
import com.example.fishfarming.entity.Dead;


/**
 * 死亡记录表包含
死亡时间
死亡数量
死亡名称(Dead)表服务接口
 *
 * @author makejava
 * @since 2023-02-28 21:01:54
 */
public interface DeadService extends IService<Dead> {
    public Result findData(Long userid,Long pondid);
    public Result remove(Long id);
    public Long search(Dead dead);
}

