package com.example.back.dto.score;

import lombok.Data;

@Data
public class ScoreAddDTO {

    /**
     * 报名ID
     */
    private Long enrollId;

    /**
     * 成绩
     */
    private Integer score;
}
