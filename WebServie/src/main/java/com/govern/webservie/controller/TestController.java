package com.govern.webservie.controller;

import com.govern.webservie.util.Result;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Nanf_bunan
 * @date: 2021-12-29 04-02
 */
@RestController
public class TestController {

    @PreAuthorize("hasAnyRole('admin')")
    @RequestMapping("/test")
    public Result test() {
        return Result.success("信息返回成功", "你好");
    }
}
