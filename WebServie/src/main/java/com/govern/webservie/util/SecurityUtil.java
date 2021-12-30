package com.govern.webservie.util;

import com.govern.webservie.entity.SysUser;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 获取当前用户的基本信息
 * @author: Nanf_bunan
 * @date: 2021-12-29 09-46
 */
public class SecurityUtil {

    /**
     * 获取用户名
     * @return
     */
    public static String getUsername() {
        try {
            return ((SysUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取用户ID
     * @return
     */
    public static Integer getUserId() {
        try {
            return ((SysUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取用户信息
     * @return
     */
    public static SysUser getUserInfo() {
        try {
            SysUser user = (SysUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            user.setUsrPwd(null);
            return user;
        } catch (Exception e) {
            return null;
        }
    }

}
