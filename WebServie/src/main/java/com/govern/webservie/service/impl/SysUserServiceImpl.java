package com.govern.webservie.service.impl;

import com.govern.webservie.entity.SysUser;
import com.govern.webservie.mapper.SysUserMapper;
import com.govern.webservie.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.govern.webservie.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Nanf_bunan
 * @since 2021-12-27
 */
@Service
@Slf4j
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public Result findAll() {
        log.info("获取用户信息");
        return Result.success("获取用户成功", sysUserMapper.findAll());
    }
}
