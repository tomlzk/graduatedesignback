package com.example.back.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.back.service.IEnrollService;
import com.example.back.dto.enroll.EnrollCreateDTO;
import com.example.back.dto.enroll.EnrollQueryDTO;
import com.example.back.dto.enroll.EnrollAuditDTO;
import com.example.back.vo.enroll.EnrollVO;
import com.example.back.utils.base.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;


/**
 * <p>
 * 报名表 前端控制器
 * </p>
 *
 * @author Tomlzk
 * @since 2026-02-03
 */
@RestController
@RequestMapping("/enroll")
public class EnrollController {

    @Autowired
    private IEnrollService enrollService;

    /**
     *
     * @param dto
     * <p>
     *     创建报名项
     * </p>
     *
     * @return
     */
    @PostMapping
    public Result<Boolean> create(@RequestBody EnrollCreateDTO dto) {
        enrollService.createEnroll(dto);
        return Result.success();
    }

    @GetMapping
    public Result<IPage<EnrollVO>> query(EnrollQueryDTO queryDTO) {
        return Result.success(enrollService.queryEnroll(queryDTO));
    }

    @PutMapping("/audit")
    public Result<Boolean> audit(@RequestBody EnrollAuditDTO auditDTO) {
        enrollService.auditEnroll(auditDTO);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        enrollService.deleteEnroll(id);
        return Result.success();
    }
}