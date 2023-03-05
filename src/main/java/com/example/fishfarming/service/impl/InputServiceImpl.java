package com.example.fishfarming.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fishfarming.common.Result;
import com.example.fishfarming.entity.Input;
import com.example.fishfarming.entity.Fishpond;
import com.example.fishfarming.mapper.InputMapper;
import com.example.fishfarming.mapper.FishpondMapper;
import com.example.fishfarming.service.InputService;
import com.example.fishfarming.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InputServiceImpl extends ServiceImpl<InputMapper, Input>  implements InputService {

    @Autowired
    private InputMapper inputMapper;
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
            List<Input> inputList=inputMapper.selectList(wrapper);
            for(Input input : inputList){
                ResultVO resultVO = new ResultVO();
                BeanUtils.copyProperties(input,resultVO);
                wrapper =new QueryWrapper();
                wrapper.eq("id",input.getPondId());
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
        Input input= inputMapper.selectOne(wrapper);
        if (input!=null){
            super.removeById(input.getId());
            return Result.succ("删除成功");
        }
        else
            return Result.fail("不存在该种类");
    }
    @Override
    public Long search(Input input) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("name",input.getName());
        Input input1= inputMapper.selectOne(wrapper);
        if (input!=null){
            return input1.getId() ;
        }
        else
            return null;
    }
}
