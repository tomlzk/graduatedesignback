package com.example.back.service.impl;

import com.example.back.entity.Score;
import com.example.back.mapper.ScoreMapper;
import com.example.back.service.IScoreService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
