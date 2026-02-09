package com.example.back.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserVO {
    private Long id;
    private String username;
    private String name;
    private String avatar;
    private String role;
    private String major;
    private LocalDateTime createTime;
}
