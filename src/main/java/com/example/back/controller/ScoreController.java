package com.example.back.controller;

import com.example.back.service.IScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 成绩表 前端控制器
 * </p>
 *
 * @author Tomlzk
 * @since 2026-02-03
 */
@RestController
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    private IScoreService iscoreService;

}
