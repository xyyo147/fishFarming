package com.example.fishfarming.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

/**
 * 鱼塘表(Fishpond)实体类
 *
 * @author makejava
 * @since 2023-03-02 22:35:54
 */
public class Fishpond implements Serializable {
    private static final long serialVersionUID = -53749405352480881L;
    
    private Long id;

    private Long pondId;

    private Long userId;
    
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPondId() {
        return pondId;
    }

    public void setPondId(Long pondId) {
        this.pondId = pondId;
    }
}

