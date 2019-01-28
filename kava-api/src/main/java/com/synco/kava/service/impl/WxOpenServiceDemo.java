package com.synco.kava.service.impl;

import com.synco.kava.properties.RedisProperties;
import com.synco.kava.properties.WechatOpenProperties;
import me.chanjar.weixin.open.api.impl.WxOpenInRedisConfigStorage;
import me.chanjar.weixin.open.api.impl.WxOpenMessageRouter;
import me.chanjar.weixin.open.api.impl.WxOpenServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;

import javax.annotation.PostConstruct;

/**
 * @author <a href="https://github.com/007gzs">007</a>
 */
@Service
@EnableConfigurationProperties({WechatOpenProperties.class, RedisProperties.class})
public class WxOpenServiceDemo extends WxOpenServiceImpl {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private WxOpenMessageRouter wxOpenMessageRouter;

    @Autowired
    WxOpenInRedisConfigStorage inRedisConfigStorage;
    @Autowired
    JedisPool getJedisPool;

    @PostConstruct
    public void init() {
        setWxOpenConfigStorage(inRedisConfigStorage);
        wxOpenMessageRouter = new WxOpenMessageRouter(this);
        wxOpenMessageRouter.rule().handler((wxMpXmlMessage, map, wxMpService, wxSessionManager) -> {
            logger.info("\n接收到 {} 公众号请求消息，内容：{}", wxMpService.getWxMpConfigStorage().getAppId(), wxMpXmlMessage);
            return null;
        }).next();
    }

    public WxOpenMessageRouter getWxOpenMessageRouter() {
        return wxOpenMessageRouter;
    }
}
