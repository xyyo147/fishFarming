package com.example.fishfarming.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fishfarming.common.Result;
import com.example.fishfarming.entity.Medicine;
import com.example.fishfarming.entity.Fishpond;
import com.example.fishfarming.mapper.MedicineMapper;
import com.example.fishfarming.mapper.FishpondMapper;
import com.example.fishfarming.service.MedicineService;
import com.example.fishfarming.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MedicineServiceImpl extends ServiceImpl<MedicineMapper, Medicine>  implements MedicineService {

    @Autowired
    private MedicineMapper medicineMapper;
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

            List<Medicine> medicineList=medicineMapper.selectList(wrapper);
            for(Medicine medicine : medicineList){
                ResultVO resultVO = new ResultVO();
                BeanUtils.copyProperties(medicine,resultVO);
                wrapper =new QueryWrapper();
                wrapper.eq("id",medicine.getPondId());
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
    public Result remove(String name) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("name",name);
        Medicine medicine= medicineMapper.selectOne(wrapper);
        if (medicine!=null){
            super.removeById(medicine.getId());
            return Result.succ("删除成功");
        }
        else
            return Result.fail("不存在该种类");
    }
    @Override
    public Long search(Medicine medicine) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("name",medicine.getName());
        Medicine medicine1= medicineMapper.selectOne(wrapper);
        if (medicine!=null){
            return medicine1.getId() ;
        }
        else
            return null;
    }
}
