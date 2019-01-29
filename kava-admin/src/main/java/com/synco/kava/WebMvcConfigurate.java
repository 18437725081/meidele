package com.synco.kava;

import com.synco.kava.inteceptor.CorsInterceptor;
import com.synco.kava.inteceptor.MyHandlerInteceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author :wangshuai
 * @date :2018/12/20
 */

@Component
public class WebMvcConfigurate implements WebMvcConfigurer {

    @Autowired
    private MyHandlerInteceptor handlerInterceptor;
    @Autowired
    private CorsInterceptor corsInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(corsInterceptor).addPathPatterns("/**");
        registry.addInterceptor(handlerInterceptor).addPathPatterns("/admin/**");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    }
}

