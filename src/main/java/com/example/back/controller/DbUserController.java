package com.example.back.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.back.dto.LoginDTO;
import com.example.back.dto.RegisterDTO;
import com.example.back.dto.UpdateUserDTO;
import com.example.back.dto.UserQueryDTO;
import com.example.back.service.IDbUserService;
import com.example.back.utils.base.Result;
import com.example.back.vo.LoginVO;
import com.example.back.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author Tomlzk
 * @since 2026-02-03
 */
@RestController
@RequestMapping("/dbUser")
public class DbUserController {

    @Autowired
    private IDbUserService dbUserService;

    /**
     * 登录
     */
    @PostMapping("/login")
    public Result<LoginVO> login(@RequestBody LoginDTO loginDTO) {
        return dbUserService.login(loginDTO);
    }

    /**
     * 注册
     */
    @PostMapping("/register")
    public Result<String> register(@RequestBody RegisterDTO registerDTO) {
        return dbUserService.register(registerDTO);
    }

    /**
     * 更新用户
     */
    @PostMapping("/update")
    public Result<String> update(@RequestBody UpdateUserDTO updateUserDTO) {
        return dbUserService.updateUser(updateUserDTO);
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/{id}")
    public Result<String> delete(@PathVariable Long id) {
        return dbUserService.delete(id);
    }

    /**
     * 查询单个用户
     */
    @GetMapping("/{id}")
    public Result<UserVO> get(@PathVariable Long id) {
        return dbUserService.getOne(id);
    }

    /**
     * 查询所有用户
     */
    @GetMapping("/list")
    public Result<List<UserVO>> list() {
        return dbUserService.listAll();
    }

    /**
     * 条件查询
     */
    @PostMapping("/query")
    public Result<IPage<UserVO>> query(@RequestBody UserQueryDTO queryDTO) {
        return dbUserService.query(queryDTO);
    }
}
