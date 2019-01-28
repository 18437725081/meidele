package com.synco.kava.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author <a href="https://github.com/007gzs">007</a>
 */
@ConfigurationProperties(prefix = "wechat.mp")
@Component
@Data
public class WechatMpProperties {
    /**
     * 设置微信公众号的appid
     */
    private String appId;
}
