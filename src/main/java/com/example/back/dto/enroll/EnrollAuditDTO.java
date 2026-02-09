package com.example.back.dto.enroll;

import lombok.Data;

/**
 * 管理员审核入参
 */
@Data
public class EnrollAuditDTO {

    /**
     * 报名记录ID
     */
    private Long enrollId;

    /**
     * approved / rejected
     */
    private String status;
}
