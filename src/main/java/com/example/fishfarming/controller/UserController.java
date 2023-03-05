package com.example.fishfarming.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.fishfarming.common.Result;
import com.example.fishfarming.entity.Fishpond;
import com.example.fishfarming.entity.Loginid;
import com.example.fishfarming.entity.User;
import com.example.fishfarming.exception.ManageException;
import com.example.fishfarming.service.FishpondService;
import com.example.fishfarming.service.LoginidService;
import com.example.fishfarming.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2023-03-01 21:59:35
 */
@Slf4j
@RestController
public class UserController {
    /**
     * 服务对象
     */
    @Autowired
    private UserService userService;
    @Autowired
    private LoginidService loginidService;
    @Autowired
    private FishpondService fishpondService;
    @ResponseBody
    @PostMapping("/register")
    public Result register(User user) throws ManageException {

//            log.info(user.getName());

            //添加用户
            user.setPermission(0);
            String password = user.getPassword();
            password = DigestUtils.md5DigestAsHex(password.getBytes());
            user.setPassword(password);
            userService.save(user);

            Fishpond fishpond =new Fishpond();
            fishpond.setPondId(1l);
            fishpond.setUserId(user.getId());
            fishpondService.save(fishpond);

        log.info("注册成功");
        return Result.succ("操作成功");
    }

    @ResponseBody
    @PostMapping("/edit")
    public Result edit(HttpServletRequest request,User user) throws ManageException {
        log.info("开始修改密码");

        Long userId = (Long) request.getSession().getAttribute("user");
//            log.info(user.getName());
        log.info("用户id是"+userId);
        //编辑
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getId,userId);
        User user1  = userService.getOne(queryWrapper);

        String password = user.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        user1.setPassword(password);
        userService.updateById(user1);
        log.info("修改密码成功");
        return Result.succ("操作成功");
    }

    @ResponseBody
    @PostMapping("/login")
    public Result login(HttpServletRequest request, User user){
        log.info("正在登錄");
        //1、将页面提交的密码password进行md5加密处理
        String password = user.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        //2、根据页面提交的用户名username查询数据库
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getName,user.getName());
        User user1  = userService.getOne(queryWrapper);

        //3、如果没有查询到则返回登录失败结果
        if(user1 == null){
            log.info("用户不存在");
            return Result.fail("登录失败");
        }

        //4、密码比对，如果不一致则返回登录失败结果
        if(!user1.getPassword().equals(password)){
            log.info("密码错误");
            return Result.fail("密码错误");
        }

        //5、登录成功，将用戶id存入Session并返回登录成功结果
        request.getSession().setAttribute("user",user1.getId());
        Long userId = (Long) request.getSession().getAttribute("user");
        log.info("存入的userid = "+userId);
        loginidService.remove(new QueryWrapper<>());
        Loginid loginid =new Loginid();
        loginid.setId(userId);
        loginidService.save(loginid);
        long id =Thread.currentThread().getId();
        log.info("线程id为：{}",id);
        return Result.succ("登录成功",user1);
    }

}

