package com.govern.webservie.config;

import com.govern.webservie.entity.SysUser;
import com.govern.webservie.service.SysUserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author: Nanf_bunan
 * @date: 2021-12-27 23-38
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private SysUserService UserService;

    /**
     * 重写，实现自定义登录逻辑
     * @return
     */
    @Override
    protected UserDetailsService userDetailsService() {
        return username -> {
            SysUser user = UserService.findByUsername(username);
            if (user != null) {
                return user;
            }
            throw new UsernameNotFoundException("用户名或密码错误!");
        };
    }

    /**
     * 配置白名单
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }
}
