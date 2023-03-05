package com.example.fishfarming.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fishfarming.entity.User;
import com.example.fishfarming.mapper.UserMapper;
import com.example.fishfarming.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements  UserService{

}
