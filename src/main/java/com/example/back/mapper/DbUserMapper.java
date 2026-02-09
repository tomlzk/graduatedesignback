package com.example.back.mapper;

import com.example.back.entity.DbUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author Tomlzk
 * @since 2026-02-03
 */
@Mapper
public interface DbUserMapper extends BaseMapper<DbUser> {

}
