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
 * 考证信息表
 * </p>
 *
 * @author Tomlzk
 * @since 2026-02-03
 */
@Getter
@Setter
@TableName("exam")
public class Exam implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 考试名称
     */
    @TableField("exam_name")
    private String examName;

    /**
     * 考试时间
     */
    @TableField("exam_time")
    private LocalDateTime examTime;

    /**
     * 考试地点
     */
    @TableField("exam_place")
    private String examPlace;

    /**
     * 考试说明
     */
    @TableField("description")
    private String description;

    /**
     * 状态：open/close
     */
    @TableField("status")
    private String status;

    @TableField("create_time")
    private LocalDateTime createTime;
}
