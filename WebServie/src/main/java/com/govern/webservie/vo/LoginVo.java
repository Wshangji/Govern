package com.govern.webservie.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: Nanf_bunan
 * @date: 2021-12-27 18-05
 */
@Data
@ApiModel(value = "登录参数")
public class LoginVo {

    @ApiModelProperty(value = "用户名" ,dataType = "String" ,required = true)
    private String username;

    @ApiModelProperty(value = "密码" ,dataType = "String" ,required = true)
    private String password;
}
