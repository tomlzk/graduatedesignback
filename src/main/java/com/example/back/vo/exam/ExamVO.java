package com.example.back.vo.exam;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExamVO {

    private Long id;

    /**
     * 考试名称
     */
    private String examName;

    /**
     * 考试时间
     */
    private LocalDateTime examTime;

    /**
     * 考试地点
     */
    private String examPlace;

    /**
     * 考试说明
     */
    private String description;

    /**
     * 状态：open/close
     */
    private String status;

    private LocalDateTime createTime;
}
