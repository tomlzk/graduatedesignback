package com.example.back.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.back.dto.score.ScoreAddDTO;
import com.example.back.dto.score.ScoreQueryDTO;
import com.example.back.dto.score.ScoreUpdateDTO;
import com.example.back.service.IScoreService;
import com.example.back.utils.base.Result;
import com.example.back.vo.score.ScoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private IScoreService scoreService;

    /**
     * 新增成绩（管理员）
     */
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody ScoreAddDTO dto) {
        scoreService.addScore(dto);
        return Result.success();
    }

    /**
     * 修改成绩（管理员）
     */
    @PutMapping("/update")
    public Result<Boolean> update(@RequestBody ScoreUpdateDTO dto) {
        scoreService.updateScore(dto);
        return Result.success();
    }

    /**
     * 删除成绩（管理员）
     */
    @DeleteMapping("/delete/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        scoreService.deleteScore(id);
        return Result.success();
    }

    /**
     * 分页查询成绩
     */
    @PostMapping("/page")
    public Result<IPage<ScoreVO>> page(@RequestBody ScoreQueryDTO dto) {
        return Result.success(scoreService.pageQuery(dto));
    }
}
