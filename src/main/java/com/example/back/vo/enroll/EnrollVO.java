package com.example.back.vo.enroll;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EnrollVO {

    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 考试ID
     */
    private Long examId;

    /**
     * 考试名称
     */
    private String examName;

    /**
     * 状态：pending/accepted/rejected
     */
    private String status;

    private LocalDateTime enrollTime;
}
