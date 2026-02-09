package com.example.back.dto.score;

import lombok.Data;

@Data
public class ScoreQueryDTO {

    private Integer pageNum = 1;
    private Integer pageSize = 10;

    private Long enrollId;
    private String result; // pass / fail
}

