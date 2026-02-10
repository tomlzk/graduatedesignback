package com.example.back.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.back.dto.exam.ExamAddDTO;
import com.example.back.dto.exam.ExamQueryDTO;
import com.example.back.dto.exam.ExamUpdateDTO;
import com.example.back.service.IExamService;
import com.example.back.utils.base.Result;
import com.example.back.vo.exam.ExamVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 考证信息表 前端控制器
 * </p>
 *
 * @author Tomlzk
 * @since 2026-02-03
 */
@RestController
@RequestMapping("/exam")
public class ExamController {
    @Autowired
    private IExamService examService;

    @PostMapping("/add")
    public Result< Boolean> addExam(@RequestBody ExamAddDTO dto)
    {
        examService.addExam(dto);
        return Result.success();
    }

    @PostMapping("/update")
    public Result< Boolean> updateExam(@RequestBody ExamUpdateDTO dto)
    {
        examService.updateExam(dto);
        return Result.success();
    }

    @GetMapping("/delete/{id}")
    public Result< Boolean> deleteExam(@PathVariable Long id)
    {
        examService.deleteExam(id);
        return Result.success();
    }

    @PostMapping("/page")
    public Result<IPage<ExamVO>> pageQuery(@RequestBody ExamQueryDTO dto)
    {
        return Result.success(examService.pageQuery(dto));
    }

}
