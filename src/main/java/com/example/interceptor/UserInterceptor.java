package com.example.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hadoop on 11/7/16.
 */
@Component
public class UserInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>PREHANDLE<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        return super.preHandle(request, response, handler);
    }
}
