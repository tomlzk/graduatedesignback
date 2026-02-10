package com.example.back.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.back.dto.exam.ExamAddDTO;
import com.example.back.dto.exam.ExamQueryDTO;
import com.example.back.dto.exam.ExamUpdateDTO;
import com.example.back.entity.Exam;
import com.example.back.vo.exam.ExamVO;

/**
 * <p>
 * 考证信息表 服务类
 * </p>
 *
 * @author Tomlzk
 * @since 2026-02-03
 */
public interface IExamService extends IService<Exam> {
    void addExam( ExamAddDTO dto );
    void updateExam( ExamUpdateDTO dto );
    void deleteExam( Long id );
    IPage<ExamVO> pageQuery(ExamQueryDTO dto );

}
