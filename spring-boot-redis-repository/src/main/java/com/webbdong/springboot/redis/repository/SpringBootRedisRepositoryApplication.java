package com.webbdong.springboot.redis.repository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * spring data 的 Repository 操作 redis
 */
@SpringBootApplication
@ServletComponentScan
public class SpringBootRedisRepositoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRedisRepositoryApplication.class, args);
    }

}
