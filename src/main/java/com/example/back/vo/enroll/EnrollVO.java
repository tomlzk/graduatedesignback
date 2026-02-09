package com.example.back.vo.enroll;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EnrollVO {

    private Long id;

    private Long userId;

    private Long examId;

    private String status;

    private LocalDateTime enrollTime;
}
