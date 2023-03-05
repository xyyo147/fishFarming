package com.example.fishfarming.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.fishfarming.common.BaseContext;
import com.example.fishfarming.common.Result;
import com.example.fishfarming.entity.Dead;
import com.example.fishfarming.entity.Loginid;
import com.example.fishfarming.entity.User;
import com.example.fishfarming.exception.ManageException;
import com.example.fishfarming.service.DeadService;
import com.example.fishfarming.service.LoginidService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * 死亡记录表包含
死亡时间
死亡数量
死亡名称(Dead)表控制层
 *
 * @author makejava
 * @since 2023-03-02 23:15:15
 */
@Slf4j
@RestController

public class DeadController {
    @Autowired
    private DeadService deadService;
    @ResponseBody
    @RequestMapping("/deadlist")
    public Result list(HttpServletRequest request)  {
//        Loginid loginid= loginidService.getOne(new QueryWrapper<>());
//        Long id=loginid.getId();
        Long userId = (Long) request.getSession().getAttribute("user");
        log.info("userid是"+ userId );
//        log.info("正在請求死亡池塘表的userid是"+ id );
        return deadService.findData(userId);
    }
    @ResponseBody
    @RequestMapping("/deaddel")
    public Result del(String name)  {
    Result result= deadService.remove(name);
        return result;
    }
    @ResponseBody
    @PostMapping("/addDead")
    public Result register(Dead dead) throws ManageException {

           log.info(dead.getName());

           dead.setPondId(1l);
           dead.setTime(LocalDateTime.now());
        deadService.save(dead);

        log.info("dead添加成功");
        return Result.succ("操作成功");
    }
    @ResponseBody
    @PostMapping("/updateDead")
    public Result update(Dead dead) throws ManageException {
        log.info(dead.getName());
        Long id=deadService.search(dead);
        dead.setId(id);
        deadService.updateById(dead);
        log.info("dead编辑成功");
        return Result.succ("操作成功");
    }

}

