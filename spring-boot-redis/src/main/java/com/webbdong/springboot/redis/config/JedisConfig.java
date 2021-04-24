package com.webbdong.springboot.redis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Jedis配置
 */
@Configuration
public class JedisConfig {

    @Bean
    @ConfigurationProperties("jedis")
    public JedisPoolConfig jedisPoolConfig() {
        return new JedisPoolConfig();
    }

    @Bean(destroyMethod = "close")
    public JedisPool jedisPool(@Value("${jedis.host}") String host,
                               @Value("${jedis.port}") int port,
                               @Value("${jedis.time-out}") int timeout,
                               @Value("${jedis.password}") String password) {
        return new JedisPool(jedisPoolConfig(), host, port, timeout, password);
    }

}
