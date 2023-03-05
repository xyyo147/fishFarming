package com.example.fishfarming.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.io.Serializable;

/**
 * 投入记录表包含
投入时间
投入数量
投入名称(Input)实体类
 *
 * @author makejava
 * @since 2023-03-02 23:29:39
 */
public class Input implements Serializable {
    private static final long serialVersionUID = 770338752454250263L;
    
    private Long id;
    
    private LocalDateTime time;
    
    private String amount;
    
    private String name;
    
    private Long pondId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
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

