package com.example.back.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.back.dto.enroll.EnrollAuditDTO;
import com.example.back.dto.enroll.EnrollCreateDTO;
import com.example.back.dto.enroll.EnrollQueryDTO;
import com.example.back.entity.Enroll;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.back.vo.enroll.EnrollVO;

import java.util.List;

/**
 * <p>
 * 报名表 服务类
 * </p>
 *
 * @author Tomlzk
 * @since 2026-02-03
 */
public interface IEnrollService extends IService<Enroll> {

    void createEnroll(EnrollCreateDTO dto);

    IPage<EnrollVO> queryEnroll(EnrollQueryDTO dto);

    void auditEnroll(EnrollAuditDTO dto);

    void deleteEnroll(Long id);
}
