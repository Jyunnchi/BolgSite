package com.wrz.intercepter;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginIntercepter implements HandlerInterceptor {
    /*
        登录拦截器，当能够得到当前用户登录的uid的话，说明可以访问，返回T
        否则重定向为登录页面，返回F
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getSession().getAttribute("uid")!=null)return true;
        response.sendRedirect(request.getContextPath()+"login.html");
        return false;
    }
}
