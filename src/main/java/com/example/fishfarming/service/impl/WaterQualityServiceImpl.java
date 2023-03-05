package com.example.fishfarming.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fishfarming.common.Result;
import com.example.fishfarming.entity.WaterQuality;
import com.example.fishfarming.entity.Fishpond;
import com.example.fishfarming.mapper.WaterQualityMapper;
import com.example.fishfarming.mapper.FishpondMapper;
import com.example.fishfarming.service.WaterQualityService;
import com.example.fishfarming.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class WaterQualityServiceImpl extends ServiceImpl<WaterQualityMapper, WaterQuality>  implements WaterQualityService {

    @Autowired
    private WaterQualityMapper waterQualityMapper;
    @Autowired
    private FishpondMapper fishpondMapper;
    @Override
    public Result findData(Long userid) {
        List<ResultVO> resultVOList=new ArrayList<>();
        Long uid;
        if (userid==null) uid=1l;
                else uid=userid;

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_id",uid);
        List<Fishpond> fishpondList=fishpondMapper.selectList(wrapper);//查询userid在池塘表里的鱼塘

        for(Fishpond fishpond : fishpondList){
            wrapper =new QueryWrapper();
            wrapper.eq("pond_id",fishpond.getId());//获取池塘id

            List<WaterQuality> waterQualityList=waterQualityMapper.selectList(wrapper);
            for(WaterQuality waterQuality : waterQualityList){
                ResultVO resultVO = new ResultVO();
                BeanUtils.copyProperties(waterQuality,resultVO);
                wrapper =new QueryWrapper();
                wrapper.eq("id",waterQuality.getPondId());
                Fishpond fishpond1 =fishpondMapper.selectOne(wrapper);
                if(fishpond1!=null)
                    resultVO.setPondName(fishpond1.getName());
                resultVOList.add(resultVO);
            }
        }
        log.info("传入的userid是"+userid);
        return Result.succ("查找成功",resultVOList);
    }
    @Override
    public Result remove(Long id) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_id",id);
        WaterQuality waterQuality= waterQualityMapper.selectOne(wrapper);
        if (waterQuality!=null){
            super.removeById(waterQuality.getId());
            return Result.succ("删除成功");
        }
        else
            return Result.fail("不存在该种类");
    }
    @Override
    public Long search(WaterQuality waterQuality) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_id",waterQuality.getUserId());
        WaterQuality waterQuality1= waterQualityMapper.selectOne(wrapper);
        if (waterQuality!=null){
            return waterQuality1.getId() ;
        }
        else
            return null;
    }
}
