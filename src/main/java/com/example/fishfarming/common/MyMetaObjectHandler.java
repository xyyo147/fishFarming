package com.example.fishfarming.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("公共字段填充[insert...]");

        Long userid=BaseContext.getCurrentId();
        metaObject.setValue("userId",userid);
        metaObject.setValue("time", LocalDateTime.now());
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
