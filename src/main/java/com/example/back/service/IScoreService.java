package com.example.back.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.back.dto.score.ScoreAddDTO;
import com.example.back.dto.score.ScoreQueryDTO;
import com.example.back.dto.score.ScoreUpdateDTO;
import com.example.back.entity.Score;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.back.vo.score.ScoreVO;

/**
 * <p>
 * 成绩表 服务类
 * </p>
 *
 * @author Tomlzk
 * @since 2026-02-03
 */
public interface IScoreService extends IService<Score> {

    void addScore(ScoreAddDTO dto);

    void updateScore(ScoreUpdateDTO dto);

    void deleteScore(Long id);

    IPage<ScoreVO> pageQuery(ScoreQueryDTO dto);
}
