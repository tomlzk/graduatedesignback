package com.example.back.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.back.dto.enroll.EnrollQueryDTO;
import com.example.back.entity.Enroll;
import com.example.back.vo.enroll.EnrollVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

/**
 * <p>
 * 报名表 Mapper 接口
 * </p>
 *
 * @author Tomlzk
 * @since 2026-02-03
 */
@Mapper
public interface EnrollMapper extends BaseMapper<Enroll> {

    IPage<EnrollVO> pageQuery(Page<?> page,
                              @Param("dto") EnrollQueryDTO dto);
}
