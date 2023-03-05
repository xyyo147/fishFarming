package com.example.fishfarming.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fishfarming.common.Result;
import com.example.fishfarming.entity.Fishpond;
import com.example.fishfarming.entity.Output;
import com.example.fishfarming.mapper.FishpondMapper;
import com.example.fishfarming.mapper.OutputMapper;
import com.example.fishfarming.service.OutputService;
import com.example.fishfarming.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OutputServiceImpl extends ServiceImpl<OutputMapper, Output>  implements OutputService {

    @Autowired
    private OutputMapper outputMapper;
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
        List<Fishpond> fishpondList=fishpondMapper.selectList(wrapper);
        for(Fishpond fishpond : fishpondList){
            wrapper =new QueryWrapper();
            wrapper.eq("pond_id",fishpond.getId());
            List<Output> outputList=outputMapper.selectList(wrapper);
            for(Output output : outputList){
                ResultVO resultVO = new ResultVO();
                BeanUtils.copyProperties(output,resultVO);
                wrapper =new QueryWrapper();
                wrapper.eq("id",output.getPondId());
                Fishpond fishpond1 =fishpondMapper.selectOne(wrapper);
                if(fishpond1!=null)
                    resultVO.setPondName(fishpond1.getName());
                resultVOList.add(resultVO);
            }
        }
        return Result.succ("查找成功",resultVOList);
    }
    @Override
    public Result remove(String name) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("name",name);
        Output output= outputMapper.selectOne(wrapper);
        if (output!=null){
            super.removeById(output.getId());
            return Result.succ("删除成功");
        }
        else
            return Result.fail("不存在该种类");
    }
    @Override
    public Long search(Output output) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("name",output.getName());
        Output output1= outputMapper.selectOne(wrapper);
        if (output!=null){
            return output1.getId() ;
        }
        else
            return null;
    }
}
