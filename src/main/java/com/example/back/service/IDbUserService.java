package com.example.back.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.back.dto.LoginDTO;
import com.example.back.dto.RegisterDTO;
import com.example.back.dto.UpdateUserDTO;
import com.example.back.dto.UserQueryDTO;
import com.example.back.entity.DbUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.back.utils.base.Result;
import com.example.back.vo.LoginVO;
import com.example.back.vo.UserVO;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Tomlzk
 * @since 2026-02-03
 */
public interface IDbUserService extends IService<DbUser> {

    Result<LoginVO> login(LoginDTO loginDTO);

    Result<String> register(RegisterDTO registerDTO);

    Result<String> updateUser(UpdateUserDTO updateUserDTO);

    Result<String> delete(Long id);

    Result<UserVO> getOne(Long id);

    Result<List<UserVO>> listAll();

    public Result<IPage<UserVO>> query(UserQueryDTO dto);
}
