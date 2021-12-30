package com.govern.webservie.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 跨域处理配置类
 * @author Nanf_bunan
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                //允许访问路径
                .addMapping("/**")
                //配置请求来源
                .allowedOrigins("http://localhost:9001")
                //允许跨域访问的方法
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                //允许携带参数
                .allowCredentials(true)
                //最大响应时间
                .maxAge(3600);
    }
}
