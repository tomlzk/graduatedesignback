package com.example.back.service.impl;

import com.example.back.entity.Exam;
import com.example.back.mapper.ExamMapper;
import com.example.back.service.IExamService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 考证信息表 服务实现类
 * </p>
 *
 * @author Tomlzk
 * @since 2026-02-03
 */
@Service
public class ExamServiceImpl extends ServiceImpl<ExamMapper, Exam> implements IExamService {

}
