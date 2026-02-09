package com.example.back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.back.dto.LoginDTO;
import com.example.back.dto.RegisterDTO;
import com.example.back.dto.UpdateUserDTO;
import com.example.back.dto.UserQueryDTO;
import com.example.back.entity.DbUser;
import com.example.back.mapper.DbUserMapper;
import com.example.back.service.IDbUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.back.utils.base.Result;
import com.example.back.vo.LoginVO;
import com.example.back.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Tomlzk
 * @since 2026-02-03
 */
@Service
public class DbUserServiceImpl
        extends ServiceImpl<DbUserMapper, DbUser>
        implements IDbUserService {

    @Autowired
    private DbUserMapper dbUserMapper;

    /**
     * 登录
     */
    @Override
    public Result<LoginVO> login(LoginDTO loginDTO) {

        DbUser dbUser = lambdaQuery()
                .eq(DbUser::getUsername, loginDTO.getUsername())
                .one();

        if (dbUser == null) {
            return Result.fail("用户不存在");
        }

        // ⚠️ 实际项目这里应该是加密校验
        if (!dbUser.getPassword().equals(loginDTO.getPassword())) {
            return Result.fail("密码错误");
        }

        // TODO: 生成 token（先占位）
        String token = "TODO_TOKEN";

        LoginVO vo = new LoginVO();
        vo.setId(dbUser.getId());
        vo.setUsername(dbUser.getUsername());
        vo.setName(dbUser.getName());
        vo.setAvatar(dbUser.getAvatar());
        vo.setRole(dbUser.getRole());
        vo.setMajor(dbUser.getMajor());
        vo.setCreateTime(dbUser.getCreateTime());
        vo.setToken(token);

        return Result.success(vo);
    }

    /**
     * 注册
     */
    @Override
    public Result<String> register(RegisterDTO registerDTO) {

        // 1. 用户名是否已存在
        boolean exists = lambdaQuery()
                .eq(DbUser::getUsername, registerDTO.getUsername())
                .exists();

        if (exists) {
            return Result.fail("用户名已存在");
        }

        // 2. DTO → Entity
        DbUser user = new DbUser();
        user.setUsername(registerDTO.getUsername());
        user.setPassword(registerDTO.getPassword()); // TODO: 加密
        user.setName(registerDTO.getName());
        user.setMajor(registerDTO.getMajor());
        user.setRole("user");
        user.setCreateTime(LocalDateTime.now());

        dbUserMapper.insert(user);

        return Result.success("注册成功");
    }

    /**
     * 更新用户
     */
    @Override
    public Result<String> updateUser(UpdateUserDTO dto) {

        DbUser user = dbUserMapper.selectById(dto.getId());
        if (user == null) {
            return Result.fail("用户不存在");
        }

        // 按需更新（不直接覆盖）
        user.setName(dto.getName());
        user.setAvatar(dto.getAvatar());
        user.setMajor(dto.getMajor());

        dbUserMapper.updateById(user);
        return Result.success("更新成功");
    }

    /**
     * 删除用户
     */
    @Override
    public Result<String> delete(Long id) {

        DbUser user = dbUserMapper.selectById(id);
        if (user == null) {
            return Result.fail("用户不存在");
        }

        dbUserMapper.deleteById(id);
        return Result.success("删除成功");
    }

    /**
     * 查询单个用户
     */
    @Override
    public Result<UserVO> getOne(Long id) {

        DbUser user = dbUserMapper.selectById(id);
        if (user == null) {
            return Result.fail("用户不存在");
        }

        return Result.success(toUserVO(user));
    }

    /**
     * 查询所有用户
     */
    @Override
    public Result<List<UserVO>> listAll() {

        List<DbUser> list = dbUserMapper.selectList(null);

        List<UserVO> voList = list.stream()
                .map(this::toUserVO)
                .toList();

        return Result.success(voList);
    }

    /**
     * 条件查询
     */
    @Override
    public Result<IPage<UserVO>> query(UserQueryDTO dto) {

        Page<DbUser> page = new Page<>(dto.getPageNum(), dto.getPageSize());

        lambdaQuery()
                .like(dto.getUsername() != null, DbUser::getUsername, dto.getUsername())
                .eq(dto.getRole() != null, DbUser::getRole, dto.getRole())
                .eq(dto.getMajor() != null, DbUser::getMajor, dto.getMajor())
                .page(page);

        IPage<UserVO> voPage = page.convert(this::toUserVO);

        return Result.success(voPage);
    }


    /**
     * Entity → VO 转换
     */
    private UserVO toUserVO(DbUser user) {
        UserVO vo = new UserVO();
        vo.setId(user.getId());
        vo.setUsername(user.getUsername());
        vo.setName(user.getName());
        vo.setAvatar(user.getAvatar());
        vo.setRole(user.getRole());
        vo.setMajor(user.getMajor());
        vo.setCreateTime(user.getCreateTime());
        return vo;
    }
}
