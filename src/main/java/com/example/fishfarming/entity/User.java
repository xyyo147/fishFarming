package com.example.fishfarming.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2023-03-01 21:59:35
 */
public class User implements Serializable {
    private static final long serialVersionUID = 161980934196619156L;
    
    private Long id;
    
    private String name;
    
    private String password;
    
    private Integer permission;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }




}

