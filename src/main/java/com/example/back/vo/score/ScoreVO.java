package com.example.back.vo.score;

import lombok.Data;

@Data
public class ScoreVO {

    private Long id;
    private Long enrollId;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户真名
     */
    private String name;
    /**
     * 考试id
     */
    private Long examId;
    /**
     * 考试名称
     */
    private String examName;
    private Integer score;
    private String result;
}
