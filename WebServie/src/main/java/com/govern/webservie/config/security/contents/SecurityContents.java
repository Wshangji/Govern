package com.govern.webservie.config.security.contents;

/**
 * 白名单
 * @author: Nanf_bunan
 * @date: 2021-12-29 08-59
 */
public class SecurityContents {

    /**
     * 放开权限校验的接口
     */
    public static final String[] NONE_SECURITY_URL_PATTERNS = {

            //后端的
            "/user/login",

            //swagger相关的
            "/doc.html",
            "/webjars/**",
            "/swagger-resources/**",
            "/v2/**",
            "/configuration/ui",
            "/configuration/security",

    };
}
