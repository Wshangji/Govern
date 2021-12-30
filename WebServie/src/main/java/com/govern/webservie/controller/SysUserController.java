package com.govern.webservie.controller;


import com.govern.webservie.service.SysUserService;
import com.govern.webservie.util.Result;
import com.govern.webservie.util.SecurityUtil;
import com.govern.webservie.vo.LoginVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Nanf_bunan
 * @since 2021-12-27
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户接口")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @ApiOperation(value = "登录接口")
    @PostMapping("/login")
    public Result login(@RequestBody LoginVo loginVo) {
        return sysUserService.login(loginVo);
    }

    @ApiOperation(value = "退出登录接口")
    @GetMapping("/logout")
    public Result logout(HttpServletRequest request, HttpServletResponse response) {
        //清除spring security用户认证信息
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return new Result(true, "登出成功");
    }

    @ApiOperation(value = "获取用户信息")
    @GetMapping("/getInfo")
    public Result getUserInfo(Principal principal) {
        if (principal == null) {
            return Result.fail("请登录");
        }
        return Result.success("获取用户信息成功", SecurityUtil.getUserInfo());
    }

}
