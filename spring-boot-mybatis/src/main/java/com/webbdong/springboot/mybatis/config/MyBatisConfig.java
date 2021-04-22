package com.webbdong.springboot.mybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置
 * @author: Webb Dong
 * @date 2018-03-25 11:45 PM
 */
@Configuration
@MapperScan("com.webbdong.springboot.mybatis.mapper")
public class MyBatisConfig {
}
