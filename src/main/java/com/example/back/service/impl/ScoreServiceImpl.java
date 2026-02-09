package com.example.back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.back.dto.score.ScoreAddDTO;
import com.example.back.dto.score.ScoreQueryDTO;
import com.example.back.dto.score.ScoreUpdateDTO;
import com.example.back.entity.Score;
import com.example.back.mapper.ScoreMapper;
import com.example.back.service.IScoreService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.back.vo.score.ScoreVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 成绩表 服务实现类
 * </p>
 *
 * @author Tomlzk
 * @since 2026-02-03
 */
@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score> implements IScoreService {

    private static final int PASS_SCORE = 60;

    @Override
    public void addScore(ScoreAddDTO dto) {

        long count = lambdaQuery()
                .eq(Score::getEnrollId, dto.getEnrollId())
                .count();
        if (count > 0) {
            throw new RuntimeException("该报名已存在成绩");
        }

        Score score = new Score();
        score.setEnrollId(dto.getEnrollId());
        score.setScore(dto.getScore());
        score.setResult(dto.getScore() >= PASS_SCORE ? "pass" : "fail");

        save(score);
    }

    @Override
    public void updateScore(ScoreUpdateDTO dto) {

        Score score = getById(dto.getId());
        if (score == null) {
            throw new RuntimeException("成绩不存在");
        }

        score.setScore(dto.getScore());
        score.setResult(dto.getScore() >= PASS_SCORE ? "pass" : "fail");

        updateById(score);
    }

    @Override
    public void deleteScore(Long id) {

        Score score = getById(id);
        if (score == null) {
            throw new RuntimeException("成绩不存在");
        }

        removeById(id);
    }

    @Override
    public IPage<ScoreVO> pageQuery(ScoreQueryDTO dto) {
        Page<Score> page = new Page<>(dto.getPageNum(), dto.getPageSize());

        LambdaQueryWrapper<Score> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(dto.getEnrollId() != null, Score::getEnrollId, dto.getEnrollId())
                .eq(dto.getResult() != null, Score::getResult, dto.getResult());

        IPage<Score> scorePage = page(page, wrapper);

        Page<ScoreVO> voPage = new Page<>();
        BeanUtils.copyProperties(scorePage, voPage);

        List<ScoreVO> voList = scorePage.getRecords().stream().map(item -> {
            ScoreVO vo = new ScoreVO();
            BeanUtils.copyProperties(item, vo);
            return vo;
        }).toList();

        voPage.setRecords(voList);
        return voPage;
    }
}
