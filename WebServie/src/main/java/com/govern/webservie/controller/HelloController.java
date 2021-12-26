package com.govern.webservie.controller;

import com.govern.webservie.util.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @RequestMapping("/hello")
    public Result test() {
        return Result.success("success","hello");
    }
}
