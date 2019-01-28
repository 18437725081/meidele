package com.synco.kava.config;

import me.chanjar.weixin.open.api.impl.WxOpenComponentServiceImpl;
import me.chanjar.weixin.open.api.impl.WxOpenInRedisConfigStorage;
import me.chanjar.weixin.open.api.impl.WxOpenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @ClassName: WechatOpenConfig
 * @Description: 微信开放平台配置
 * @author: cangcang
 * @date: 2018年9月8日 下午2:50:40
 */
@Component
public class WechatOpenConfig {

    @Autowired
    WxOpenInRedisConfigStorage wxOpenInRedisConfigStorage;

    @Bean
    public WxOpenComponentServiceImpl wxOpenComponentServiceImpl() {
        WxOpenComponentServiceImpl wxOpenComponentServiceImpl = new WxOpenComponentServiceImpl(wxOpenServiceImpl());
        return wxOpenComponentServiceImpl;
    }

    @Bean
    public WxOpenServiceImpl wxOpenServiceImpl() {
        WxOpenServiceImpl wxOpenServiceImpl = new WxOpenServiceImpl();
        wxOpenServiceImpl.setWxOpenConfigStorage(wxOpenInRedisConfigStorage);
        return wxOpenServiceImpl;
    }
}
