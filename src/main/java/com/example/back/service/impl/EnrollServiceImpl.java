package com.example.back.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.back.dto.enroll.EnrollAuditDTO;
import com.example.back.dto.enroll.EnrollCreateDTO;
import com.example.back.dto.enroll.EnrollQueryDTO;
import com.example.back.entity.Enroll;
import com.example.back.mapper.EnrollMapper;
import com.example.back.service.IEnrollService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.back.vo.enroll.EnrollVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 报名表 服务实现类
 * </p>
 *
 * @author Tomlzk
 * @since 2026-02-03
 */
@Service
public class EnrollServiceImpl extends ServiceImpl<EnrollMapper, Enroll> implements IEnrollService {

    @Autowired
    private EnrollMapper enrollMapper;

    @Override
    public void createEnroll(EnrollCreateDTO dto) {
        Enroll enroll = new Enroll();
        enroll.setUserId(dto.getUserId());
        enroll.setExamId(dto.getExamId());
        enroll.setEnrollTime(LocalDateTime.now());
        enrollMapper.insert(enroll);
    }

    @Override
    public IPage<EnrollVO> queryEnroll(EnrollQueryDTO dto) {
        Page<Enroll> enrollVOPage = new Page<>(dto.getPageNum(), dto.getPageSize());

        lambdaQuery()
                .eq(dto.getUserId() != null, Enroll::getUserId, dto.getUserId())
                .eq(dto.getExamId() != null, Enroll::getExamId, dto.getExamId())
                .page(enrollVOPage);

        return enrollVOPage.convert(this::toEnrollVO);
    }

    /**
     *
     * @param dto
     * 审核
     */
    @Override
    public void auditEnroll(EnrollAuditDTO dto) {
        Enroll enroll = new Enroll();
        enroll.setId(dto.getEnrollId());
        enroll.setStatus(dto.getStatus());
        enrollMapper.updateById(enroll);
    }

    @Override
    public void deleteEnroll(Long id) {
        enrollMapper.deleteById(id);
    }

    private EnrollVO toEnrollVO(Enroll enroll) {
        EnrollVO enrollVO = new EnrollVO();
        enrollVO.setId(enroll.getId());
        enrollVO.setUserId(enroll.getUserId());
        enrollVO.setExamId(enroll.getExamId());
        enrollVO.setStatus(enroll.getStatus());
        enrollVO.setEnrollTime(enroll.getEnrollTime());

        return enrollVO;
    }

}
