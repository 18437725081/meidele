package com.synco.kava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @Author:wangshuai
 * @Date:2019/1/28
 */

@SpringBootApplication
@EnableJpaRepositories(value = {"com.synco.kava.repository"})
public class KavaApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(KavaApiApplication.class);
    }

}

