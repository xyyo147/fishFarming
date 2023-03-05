package com.example.fishfarming;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@Slf4j
@SpringBootApplication
//@ServletComponentScan
@MapperScan("com.example.fishfarming.mapper")
public class FishFarmingApplication {

    public static void main(String[] args) {
        SpringApplication.run(FishFarmingApplication.class, args);
        log.info("项目启动成功");
    }

}
