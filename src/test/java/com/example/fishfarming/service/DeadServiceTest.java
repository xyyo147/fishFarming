package com.example.fishfarming.service;

import com.example.fishfarming.common.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DeadServiceTest {
@Autowired
private  DeadService service;
    @Test
    void findData() {
        Result result=service.findData(1L);
        int i=0;
    }
//    @Test
//    void del() {
//        Result result=service.findData(1L);
//        int i=0;
//    }
}