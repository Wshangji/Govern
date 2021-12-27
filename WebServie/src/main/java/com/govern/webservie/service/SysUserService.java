package com.govern.webservie.service;

import com.govern.webservie.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.govern.webservie.mapper.SysUserMapper;
import com.govern.webservie.util.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Nanf_bunan
 * @since 2021-12-27
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 获取所有的用户
     * @return
     */
    Result findAll();
}
