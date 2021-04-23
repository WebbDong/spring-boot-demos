package com.webbdong.springboot.cache.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.time.Duration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Spring Cache配置
 */
@Configuration
@EnableCaching(proxyTargetClass = true)
public class SpringCacheConfig {

    /**
     * 自定义缓存管理器
     */
    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory factory) {
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();
        Set<String> cacheNames = new HashSet<>();
        cacheNames.add("orderInfo");
        cacheNames.add("default");

        Map<String, RedisCacheConfiguration> configMap = new HashMap<>();
        // orderInfo 缓存名，有效时间 5 分钟
        configMap.put("orderInfo", config.entryTtl(Duration.ofMinutes(5)));
        // default 缓存名，永久有效
        configMap.put("default", config);
        return RedisCacheManager
                .builder(factory)
                .initialCacheNames(cacheNames)
                .withInitialCacheConfigurations(configMap)
                .build();
    }

}
