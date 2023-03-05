package com.example.fishfarming.controller;

import com.example.fishfarming.common.Result;
import com.example.fishfarming.entity.Medicine;
import com.example.fishfarming.exception.ManageException;
import com.example.fishfarming.service.MedicineService;
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

public class MedicineController {
    @Autowired
    private MedicineService medicineService;
    @ResponseBody
    @RequestMapping("/medicinelist")
    public Result list(HttpServletRequest request)  {
//        Loginid loginid= loginidService.getOne(new QueryWrapper<>());
//        Long id=loginid.getId();
        Long userId = (Long) request.getSession().getAttribute("user");
        log.info("userid是"+ userId );
//        log.info("正在請求死亡池塘表的userid是"+ id );
        return medicineService.findData(userId);
    }
    @ResponseBody
    @RequestMapping("/medicinedel")
    public Result del(String name)  {
    Result result= medicineService.remove(name);
        return result;
    }
    @ResponseBody
    @PostMapping("/addMedicine")
    public Result register(Medicine medicine) throws ManageException {

           log.info(medicine.getName());

           medicine.setPondId(1l);
           medicine.setTime(LocalDateTime.now());
        medicineService.save(medicine);

        log.info("medicine添加成功");
        return Result.succ("操作成功");
    }
    @ResponseBody
    @PostMapping("/updateMedicine")
    public Result update(Medicine medicine) throws ManageException {
        log.info(medicine.getName());
        Long id=medicineService.search(medicine);
        medicine.setId(id);
        medicineService.updateById(medicine);
        log.info("medicine编辑成功");
        return Result.succ("操作成功");
    }

}

