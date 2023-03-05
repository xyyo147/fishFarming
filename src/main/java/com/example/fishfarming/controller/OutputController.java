package com.example.fishfarming.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.fishfarming.common.BaseContext;
import com.example.fishfarming.common.Result;
import com.example.fishfarming.entity.Loginid;
import com.example.fishfarming.entity.Output;
import com.example.fishfarming.exception.ManageException;
import com.example.fishfarming.service.LoginidService;
import com.example.fishfarming.service.OutputService;
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

public class OutputController {
    @Autowired
    private OutputService outputService;
    @Autowired
    private LoginidService loginidService;
    @ResponseBody
    @RequestMapping("/outputlist")
    public Result list(HttpServletRequest request)  {
//        Loginid loginid= loginidService.getOne(new QueryWrapper<>());
//        Long id=loginid.getId();
        Long userId = (Long) request.getSession().getAttribute("user");
        log.info("userid是"+ userId );
//        log.info("正在請求产出池塘表的userid是"+id);
        return outputService.findData(userId);
    }
    @ResponseBody
    @RequestMapping("/outputdel")
    public Result del(String name)  {
    Result result= outputService.remove(name);
        return result;
    }
    @ResponseBody
    @PostMapping("/addOutput")
    public Result register(Output output) throws ManageException {

           log.info(output.getName());

           output.setPondId(1l);
           output.setTime(LocalDateTime.now());
        outputService.save(output);



        log.info("output添加成功");
        return Result.succ("操作成功");
    }
    @ResponseBody
    @PostMapping("/updateOutput")
    public Result update(Output output) throws ManageException {
        log.info(output.getName());
        Long id=outputService.search(output);
        output.setId(id);
        outputService.updateById(output);
        log.info("output编辑成功");
        return Result.succ("操作成功");
    }

}

