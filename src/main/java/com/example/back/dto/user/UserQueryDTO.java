package com.example.back.dto.user;

import lombok.Data;

@Data
public class UserQueryDTO {

    /**
     * 当前页（从 1 开始）
     */
    private Integer pageNum = 1;

    /**
     * 每页条数
     */
    private Integer pageSize = 10;
    /**
     * 用户名（模糊）
     */
    private String username;

    /**
     * 角色
     */
    private String role;

    /**
     * 专业
     */
    private String major;
}

