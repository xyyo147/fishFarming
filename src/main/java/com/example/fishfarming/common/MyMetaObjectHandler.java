package com.example.fishfarming.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
//        log.info("公共字段填充");
//
//        long id =Thread.currentThread().getId();
//        log.info("线程id为：{}",id);
//        metaObject.setValue("userid");

    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
