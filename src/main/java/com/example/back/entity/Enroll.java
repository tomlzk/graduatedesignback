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
 * 报名表
 * </p>
 *
 * @author Tomlzk
 * @since 2026-02-03
 */
@Getter
@Setter
@TableName("enroll")
public class Enroll implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 学生ID
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 考试ID
     */
    @TableField("exam_id")
    private Long examId;

    /**
     * 报名状态：pending/approved/rejected
     */
    @TableField("status")
    private String status;

    @TableField("enroll_time")
    private LocalDateTime enrollTime;
}
