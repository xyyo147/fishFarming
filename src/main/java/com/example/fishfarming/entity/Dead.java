package com.example.fishfarming.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.io.Serializable;

/**
 * 死亡记录表包含
死亡时间
死亡数量
死亡名称(Dead)实体类
 *
 * @author makejava
 * @since 2023-02-28 21:01:54
 */
public class Dead implements Serializable {
    private static final long serialVersionUID = 830852127636267368L;
    
    private Long id;
//
//    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime time;
    
    private String amount;
    
    private String name;

//    @TableField(fill = FieldFill.INSERT)
    private Long pondId;

    public void setPondId(Long pondId) {
        this.pondId = pondId;
    }

    public Long getPondId() {
        return pondId;
    }

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

}

