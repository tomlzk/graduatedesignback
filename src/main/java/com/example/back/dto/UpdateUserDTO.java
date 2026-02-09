package com.example.back.dto;

import lombok.Data;

@Data
public class UpdateUserDTO {

    /**
     * 用户 ID（必须）
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 头像地址
     */
    private String avatar;

    /**
     * 专业
     */
    private String major;
}
