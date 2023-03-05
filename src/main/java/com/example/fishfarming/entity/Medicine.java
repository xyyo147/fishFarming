package com.example.fishfarming.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.io.Serializable;

/**
 * 用药记录表包含
用药时间
用药用量
用药名称(Medicine)实体类
 *
 * @author makejava
 * @since 2023-03-04 20:52:25
 */
public class Medicine implements Serializable {
    private static final long serialVersionUID = 487455436442571169L;
    
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

