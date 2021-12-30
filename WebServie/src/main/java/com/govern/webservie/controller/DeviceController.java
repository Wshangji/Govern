package com.govern.webservie.controller;


import com.govern.webservie.service.DeviceService;
import com.govern.webservie.util.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Nanf_bunan
 * @since 2021-12-30
 */
@RestController
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @ApiOperation(value = "获取所有设备信息")
    @GetMapping("/getAllInfo")
    Result getAllDeviceInfo() {
        return null;
    }

    @ApiOperation(value = "根据id获取设备信息")
    @GetMapping("/getInfo")
    Result getDeviceInfo(int id) {
        return null;
    }

}
