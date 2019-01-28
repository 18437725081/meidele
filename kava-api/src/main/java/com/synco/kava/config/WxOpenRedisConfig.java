package com.synco.kava.config;

import com.synco.kava.properties.WechatOpenProperties;
import me.chanjar.weixin.open.api.impl.WxOpenInRedisConfigStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;

/**
 * @author wangshuai
 * @date 2018/12/21
 */
@Component
public class WxOpenRedisConfig {

    @Autowired
    private WechatOpenProperties wechatOpenProperties;
    @Autowired
    private JedisPool jedisPool;

    @Bean
    public WxOpenInRedisConfigStorage wxOpenInRedisConfigStorage() {
        WxOpenInRedisConfigStorage inRedisConfigStorage = new WxOpenInRedisConfigStorage(jedisPool);
        inRedisConfigStorage.setComponentAppId(wechatOpenProperties.getComponentAppId());
        inRedisConfigStorage.setComponentAppSecret(wechatOpenProperties.getComponentSecret());
        inRedisConfigStorage.setComponentToken(wechatOpenProperties.getComponentToken());
        inRedisConfigStorage.setComponentAesKey(wechatOpenProperties.getComponentAesKey());
        return inRedisConfigStorage;
    }

}
