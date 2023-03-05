package com.example.fishfarming.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DeadMapperTest {
@Autowired
    private DeadMapper mapper;
@Test
    void test(){
    mapper.selectList(null).forEach(System.out::println);
}
}