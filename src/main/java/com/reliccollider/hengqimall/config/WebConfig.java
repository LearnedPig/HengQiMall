package com.reliccollider.hengqimall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class WebConfig {

    @Bean
    public CorsFilter corsFilter() {
        // 创建 CORS 配置对象
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOriginPattern("http://localhost:8080"); // 或你的前端地址
        config.setAllowCredentials(true);     // 允许发送 Cookie
        config.addAllowedHeader("*");         // 允许所有请求头
        config.addAllowedMethod("*");         // 允许所有请求方法：GET、POST、PUT、DELETE 等

        // 注册配置到 URL
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config); // 对所有接口生效

        return new CorsFilter(source);
    }
}
