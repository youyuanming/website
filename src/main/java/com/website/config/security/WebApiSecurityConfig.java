package com.website.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebApiSecurityConfig implements WebMvcConfigurer {

    public static final String CLIENT_ID = "clientId";

    @Bean
    public SecurityInterceptor getSecurityInterceptor() {
        return new SecurityInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());
        // 排除配置--对下面的不进行拦截
        addInterceptor.excludePathPatterns("/test/login");
        addInterceptor.excludePathPatterns("/index");
        addInterceptor.excludePathPatterns("/login");
        addInterceptor.excludePathPatterns("/error");
        // 拦截配置
        addInterceptor.addPathPatterns("/**");
    }
}
