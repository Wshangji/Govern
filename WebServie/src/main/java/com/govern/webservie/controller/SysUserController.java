package com.govern.webservie.controller;


import com.govern.webservie.service.SysUserService;
import com.govern.webservie.util.Result;
import com.govern.webservie.vo.LoginVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
