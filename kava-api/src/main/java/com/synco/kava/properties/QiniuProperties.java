package com.synco.kava.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @description: Qiniu配置
 * @author: cangcang
 * @create: 2018-10-28 17:09
 **/
@Component
@ConfigurationProperties(prefix="qiniu")
@Data
public class QiniuProperties {

    /**
     * appid
     */
    private String ACCESS_KEY;
    /**
     * appsecret
     */
    private String SECRET_KEY;

    /**
     * 空间名
     */
    private String BUCKET_NAME;
    /**
     * 主域名
     */
    private String DOMAIN;
}
