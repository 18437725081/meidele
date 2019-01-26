package com.synco.kava.inteceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 跨域CORS
 * @author: cangcang
 * @create: 2018-10-26 10:29
 **/
@Component
public class CorsInterceptor extends HandlerInterceptorAdapter {

    public static final String OPTIONS = "OPTIONS";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //支持全域名访问，不安全，部署后需要固定限制为客户端网址
        response.setHeader("Access-Control-Allow-Origin", "*");
        //自定义请求头信息
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With,content-type, token");
        //允许请求的方法
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        //允许客户端发送Cookie到服务器，但是这样Access-Control-Allow-Origin就不能设为星号，必须指定明确的、与请求网页一致的域名。
        response.setHeader("Access-Control-Allow-Credentials","false");
        response.setCharacterEncoding("UTF-8");
        if ((OPTIONS.equals(request.getMethod()))) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
            return true;
        }
        return true;
    }
}