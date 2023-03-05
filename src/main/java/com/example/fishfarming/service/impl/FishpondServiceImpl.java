package com.example.fishfarming.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fishfarming.entity.Fishpond;
import com.example.fishfarming.mapper.FishpondMapper;
import com.example.fishfarming.service.FishpondService;
import org.springframework.stereotype.Service;

@Service
public class FishpondServiceImpl extends ServiceImpl<FishpondMapper, Fishpond>  implements FishpondService {
}
