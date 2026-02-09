package com.example.back.dto.enroll;

import lombok.Data;

/**
 * 查询入参
 */
@Data
public class EnrollQueryDTO {

    private Long userId;

    private Long examId;

    /**
     * pending / approved / rejected
     */
    private String status;

    private Integer pageNum = 1;

    private Integer pageSize = 10;
}
