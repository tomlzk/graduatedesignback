package com.example.back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.back.dto.exam.ExamAddDTO;
import com.example.back.dto.exam.ExamQueryDTO;
import com.example.back.dto.exam.ExamUpdateDTO;
import com.example.back.entity.Exam;
import com.example.back.mapper.ExamMapper;
import com.example.back.service.IExamService;
import com.example.back.vo.exam.ExamVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 考证信息表 服务实现类
 * </p>
 *
 * @author Tomlzk
 * @since 2026-02-03
 */
@Service
public class ExamServiceImpl extends ServiceImpl<ExamMapper, Exam>
        implements IExamService {

    @Override
    public void addExam(ExamAddDTO dto) {
        Exam exam = new Exam();
        BeanUtils.copyProperties(dto, exam);
        save(exam);
    }

    @Override
    public void updateExam(ExamUpdateDTO dto) {
        Exam exam = new Exam();
        BeanUtils.copyProperties(dto, exam);
        updateById(exam);
    }

    @Override
    public void deleteExam(Long id) {
        removeById(id);
    }

    @Override
    public IPage<ExamVO> pageQuery(ExamQueryDTO dto) {

        Page<Exam> page = new Page<>(dto.getPageNum(), dto.getPageSize());

        LambdaQueryWrapper<Exam> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(dto.getExamName() != null, Exam::getExamName, dto.getExamName())
                .eq(dto.getExamTime() != null, Exam::getExamTime, dto.getExamTime())
                .eq(dto.getExamPlace() != null, Exam::getExamPlace, dto.getExamPlace())
                .eq(dto.getDescription() != null, Exam::getDescription, dto.getDescription())
                .eq(dto.getStatus() != null, Exam::getStatus, dto.getStatus());

        IPage<Exam> examPage = page(page, wrapper);

        Page<ExamVO> voPage = new Page<>();
        BeanUtils.copyProperties(examPage, voPage);

        List<ExamVO> voList = examPage.getRecords().stream().map(item -> {
            ExamVO vo = new ExamVO();
            BeanUtils.copyProperties(item, vo);
            return vo;
        }).toList();

        voPage.setRecords(voList);
        return voPage;
    }
}
