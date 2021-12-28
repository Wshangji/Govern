package com.govern.webservie.service;

import com.govern.webservie.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.govern.webservie.util.Result;
import com.govern.webservie.vo.LoginVo;

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
     * 登录接口
     * @param loginVo 用户名和密码
     * @return
     */
    Result login(LoginVo loginVo);

    /**
     * 根据用户名获取用户对象
     * @param username
     * @return
     */
    SysUser findByUsername(String username);
}
