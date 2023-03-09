package com.example.fishfarming.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ResultVO {
    private Long id;

    private String dbScripId;

    private Date time;

    private String amount;

    private String name;

    private String pondName;
}
