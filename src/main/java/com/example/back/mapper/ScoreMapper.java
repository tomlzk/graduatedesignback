package com.example.back.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.back.dto.score.ScoreQueryDTO;
import com.example.back.entity.Score;
import com.example.back.vo.score.ScoreVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

/**
 * <p>
 * 成绩表 Mapper 接口
 * </p>
 *
 * @author Tomlzk
 * @since 2026-02-03
 */
@Mapper
public interface ScoreMapper extends BaseMapper<Score> {

    IPage<ScoreVO> pageQuery(Page<?> page, @Param("dto") ScoreQueryDTO dto);
}
