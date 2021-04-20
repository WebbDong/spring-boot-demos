package com.webbdong.springboot.aop.config;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatisPlus配置
 */
@Configuration
@MapperScan(basePackages = "com.webbdong.springboot.aop.dao.mapper", markerInterface = BaseMapper.class)
public class MyBatisPlusConfig {

}
