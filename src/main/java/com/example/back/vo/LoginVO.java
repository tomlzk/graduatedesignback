package com.example.back.vo;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class LoginVO {
    private Long id;
    private String username;
    private String name;
    private String token;
    private String avatar;
    private String role;
    private String major;
    private LocalDateTime createTime;
}
