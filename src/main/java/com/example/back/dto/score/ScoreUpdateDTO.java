package com.example.back.dto.score;

import lombok.Data;

@Data
public class ScoreUpdateDTO {

    private Long id;       // 成绩ID
    private Integer score; // 新成绩
    private String result;
}
