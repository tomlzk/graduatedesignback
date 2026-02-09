package com.example.back.dto;

import lombok.Data;

@Data
public class RegisterDTO {

    /**
     * 登录账号
     */
    private String username;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 专业
     */
    private String major;
}
