package com.wrz.configure;

import com.wrz.intercepter.LoginIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    /*
        添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注射器
        InterceptorRegistration registration=registry.addInterceptor(new LoginIntercepter());
        //给一些页面放行
        registration.excludePathPatterns(
                "/login.html",
                "/register.html",
                "/css/**",
                "/imgs/**",
                "/font/css",
                "/img/css",
                "/user/**"
        );
    }
}
