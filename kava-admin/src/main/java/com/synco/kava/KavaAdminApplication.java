package com.synco.kava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 后台启动类
 * @Author:wangshuai
 * @Date:2019/1/25
 */

@SpringBootApplication
@EnableJpaRepositories(value = "com.synco.kava.repository")
public class KavaAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(KavaAdminApplication.class);
    }
}

