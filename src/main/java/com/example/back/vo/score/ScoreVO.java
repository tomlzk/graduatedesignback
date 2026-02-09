package com.example.back.vo.score;

import lombok.Data;

@Data
public class ScoreVO {

    private Long id;
    private Long enrollId;
    private Integer score;
    private String result;
}
