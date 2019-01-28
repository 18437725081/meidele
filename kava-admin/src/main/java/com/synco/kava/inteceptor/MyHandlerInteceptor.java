package com.synco.kava.inteceptor;

import com.synco.kava.annotation.Auth;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 * @Author:wangshuai
 * @Date:2019/1/3
 */

@Component
public class MyHandlerInteceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HandlerMethod method = (HandlerMethod) handler;
        Auth methodAnnotation = method.getMethodAnnotation(Auth.class);
        boolean value = methodAnnotation.value();
        if (!value) {
            //不需要登录
            return true;
        }
        String token = request.getHeader("token");
        response.setHeader("Content-type", "text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        if (StringUtils.isEmpty(token)) {
            response.getWriter().write("请去登录");
            return false;
        }
        return true;
    }
}

