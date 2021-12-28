package com.govern.webservie.mapper;

import com.govern.webservie.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Nanf_bunan
 * @since 2021-12-27
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    List<SysUser> findAll();

    SysUser findByUsername(String username);
}
