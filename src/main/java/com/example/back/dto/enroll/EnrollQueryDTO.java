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

    /**
     * 页号
     */
    private Integer pageNum = 1;


    /**
     * 一页的最大项数
     */
    private Integer pageSize = 10;
}
