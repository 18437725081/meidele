package com.synco.kava.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @description: redis参数配置
 * @author: cangcang
 * @create: 2018-10-26 16:48
 **/

@Component
@ConfigurationProperties(prefix="spring.redis")
@Data
public class RedisProperties {
	/**
	 * 主机
	 */
	private String host;
	/**
	 * 端口
	 */
	private Integer port;
	/**
	 * 超时时间，秒
	 */
	private Integer timeout;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 最大连接数
	 */
	private Integer poolMaxTotal;
	/**
	 * 最大空闲数
	 */
	private Integer poolMaxIdle;
	/**
	 * 最大等待
	 */
	private Integer poolMaxWait;
}
