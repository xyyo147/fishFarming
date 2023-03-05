package com.example.fishfarming.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.fishfarming.common.BaseContext;
import com.example.fishfarming.common.Result;
import com.example.fishfarming.entity.Input;
import com.example.fishfarming.entity.Loginid;
import com.example.fishfarming.exception.ManageException;
import com.example.fishfarming.service.InputService;
import com.example.fishfarming.service.LoginidService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;


@Slf4j
@RestController

public class InputController {
    @Autowired
    private InputService inputService;
    @Autowired
    private LoginidService loginidService;
    @ResponseBody
    @RequestMapping("/inputlist")
    public Result list(HttpServletRequest request)  {
//        Loginid loginid= loginidService.getOne(new QueryWrapper<>());
//        Long id=loginid.getId();
        Long userId = (Long) request.getSession().getAttribute("user");
        log.info("userid是"+ userId );
        log.info("正在請求投入池塘表的userid是"+userId);
        return inputService.findData(userId);
    }
    @ResponseBody
    @RequestMapping("/inputdel")
    public Result del(String name)  {
    Result result= inputService.remove(name);
        return result;
    }
    @ResponseBody
    @PostMapping("/addInput")
    public Result register(Input input) throws ManageException {

           log.info(input.getName());

           input.setPondId(1l);
           input.setTime(LocalDateTime.now());
        inputService.save(input);



        log.info("input添加成功");
        return Result.succ("操作成功");
    }
    @ResponseBody
    @PostMapping("/updateInput")
    public Result update(Input input) throws ManageException {
        log.info(input.getName());
        Long id=inputService.search(input);
        input.setId(id);
        inputService.updateById(input);
        log.info("input编辑成功");
        return Result.succ("操作成功");
    }

}

