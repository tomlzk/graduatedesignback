package com.example.back.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 成绩表
 * </p>
 *
 * @author Tomlzk
 * @since 2026-02-03
 */
@Getter
@Setter
@TableName("score")
public class Score implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 报名ID
     */
    @TableField("enroll_id")
    private Long enrollId;

    /**
     * 成绩
     */
    @TableField("score")
    private Integer score;

    /**
     * 结果：pass/fail
     */
    @TableField("result")
    private String result;
}
