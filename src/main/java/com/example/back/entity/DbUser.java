package com.example.back.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author Tomlzk
 * @since 2026-02-03
 */
@Getter
@Setter
@TableName("db_user")
public class DbUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 登录账号/学号
     */
    @TableField("username")
    private String username;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 姓名
     */
    @TableField("name")
    private String name;

    /**
     * 头像
     */
    @TableField("avatar")
    private String avatar;


    /**
     * 角色：student/admin
     */
    @TableField("role")
    private String role;

    /**
     * 专业
     */
    @TableField("major")
    private String major;

    @TableField("create_time")
    private LocalDateTime createTime;
}
