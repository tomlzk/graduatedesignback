package com.example.back.dto.enroll;

import lombok.Data;

//报名入参
@Data
public class EnrollCreateDTO {

    /**
     * 学生ID
     */
    private Long userId;

    /**
     * 考试ID
     */
    private Long examId;
}
