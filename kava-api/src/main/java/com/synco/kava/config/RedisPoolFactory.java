package com.synco.kava.config;

import com.synco.kava.properties.RedisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @description:
 * @author: cangcang
 * @create: 2018-10-26 16:48
 **/
@Service
public class RedisPoolFactory {

    @Autowired
    private RedisProperties redisProperties;

    @Bean
    public JedisPool JedisPoolFactory() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        JedisPool jp = new JedisPool(poolConfig, redisProperties.getHost(), redisProperties.getPort(),
                redisProperties.getTimeout() * 1000, redisProperties.getPassword(), 0);
        return jp;
    }
}
