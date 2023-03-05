package com.example.fishfarming.entity;

import java.io.Serializable;

/**
 * (Loginid)实体类
 *
 * @author makejava
 * @since 2023-03-04 17:57:17
 */
public class Loginid implements Serializable {
    private static final long serialVersionUID = 735669958596873757L;
    
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}

