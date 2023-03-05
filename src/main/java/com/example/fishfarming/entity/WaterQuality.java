package com.example.fishfarming.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 鱼塘水质表
氨氮，NH
温度，temperature
溶解氧，oxygen
亚硝酸盐，NO2
酸碱度，ph
硫化氢H2S(WaterQuality)实体类
 *
 * @author makejava
 * @since 2023-03-04 21:21:32
 */
public class WaterQuality implements Serializable {
    private static final long serialVersionUID = -73166455159257566L;
    
    private String nh;
    
    private Long id;
    
    private String temperature;
    
    private String oxygen;
    
    private String nitrite;
    
    private String ph;
    
    private String h2s;
    
    private String no2;
    
    private Long pondId;
    
    private Date time;
    
    private Long userId;


    public String getNh() {
        return nh;
    }

    public void setNh(String nh) {
        this.nh = nh;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getOxygen() {
        return oxygen;
    }

    public void setOxygen(String oxygen) {
        this.oxygen = oxygen;
    }

    public String getNitrite() {
        return nitrite;
    }

    public void setNitrite(String nitrite) {
        this.nitrite = nitrite;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getH2s() {
        return h2s;
    }

    public void setH2s(String h2s) {
        this.h2s = h2s;
    }

    public String getNo2() {
        return no2;
    }

    public void setNo2(String no2) {
        this.no2 = no2;
    }

    public Long getPondId() {
        return pondId;
    }

    public void setPondId(Long pondId) {
        this.pondId = pondId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}

