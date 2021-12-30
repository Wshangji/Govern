package com.govern.webservie.controller;

import com.govern.webservie.util.Result;
import com.govern.webservie.util.SecurityUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author: Nanf_bunan
 * @date: 2021-12-29 04-02
 */
@RestController
@Api(value = "测试接口")
public class TestController {

    @ApiOperation(value = "测试Test")
    @PreAuthorize("hasAnyRole('ROLE_admin')")
    @GetMapping("/test")
    public Result test() {
        return Result.success("信息返回成功", "你好");
    }
}
