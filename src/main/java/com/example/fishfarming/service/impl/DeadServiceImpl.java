package com.example.fishfarming.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fishfarming.common.Result;
import com.example.fishfarming.entity.Dead;
import com.example.fishfarming.entity.Fishpond;
import com.example.fishfarming.mapper.DeadMapper;
import com.example.fishfarming.mapper.FishpondMapper;
import com.example.fishfarming.service.DeadService;
import com.example.fishfarming.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
public class DeadServiceImpl extends ServiceImpl<DeadMapper, Dead>  implements DeadService {

    @Autowired
    private DeadMapper deadMapper;
    @Autowired
    private FishpondMapper fishpondMapper;
    @Override
    public Result findData(Long userid,Long pondid) {
        List<ResultVO> resultVOList=new ArrayList<>();
        Long uid;
        if (userid==null) uid=1l;
                else uid=userid;

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_id",uid );
        wrapper.eq("pond_id",pondid);
        List<Fishpond> fishpondList=fishpondMapper.selectList(wrapper);//查询userid在池塘表里的鱼塘
        for(Fishpond fishpond : fishpondList){
            wrapper =new QueryWrapper();
            wrapper.eq("pond_id",fishpond.getId());//获取池塘id

            List<Dead> deadList=deadMapper.selectList(wrapper);
            for(Dead dead : deadList){
                ResultVO resultVO = new ResultVO();
                BeanUtils.copyProperties(dead,resultVO);
                wrapper =new QueryWrapper();
                wrapper.eq("id",dead.getPondId());
                Fishpond fishpond1 =fishpondMapper.selectOne(wrapper);
                if(fishpond1!=null){
                    resultVO.setPondName(fishpond1.getName());
                    resultVO.setDbScripId(dead.getId().toString());
                }

                resultVOList.add(resultVO);
            }
        }
        log.info("传入的userid是"+userid);
        return Result.succ("查找成功",resultVOList);
    }
    @Override
    public Result remove(Long id) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id",id);
        Dead dead= deadMapper.selectOne(wrapper);
        if (dead!=null){
            super.removeById(dead.getId());
            return Result.succ("删除成功");
        }
        else
            return Result.fail("不存在该种类");
    }
    @Override
    public Long search(Dead dead) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("name",dead.getName());
        Dead dead1= deadMapper.selectOne(wrapper);
        if (dead!=null){
            return dead1.getId() ;
        }
        else
            return null;
    }
}
