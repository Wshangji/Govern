package com.govern.webservie.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Nanf_bunan
 * @date: 2021-12-27 16-09
 */
@Configuration
@MapperScan("com.govern.webservie.mapper")
public class MybatisPlusConfig {

    /**
     * 配置分页
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }
}
