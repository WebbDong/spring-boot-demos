package com.webbdong.springboot.cache.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * Spring Cache配置
 */
@Configuration
@EnableCaching(proxyTargetClass = true)
public class SpringCacheConfig {

}
