package com.webbdong.springboot.redis.cache.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.webbdong.springboot.redis.cache.consts.CacheNameConsts;
import com.webbdong.springboot.redis.cache.jackson.deserializer.MoneyJsonDeserializer;
import com.webbdong.springboot.redis.cache.jackson.serializer.MoneyJsonSerializer;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.time.Duration;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Spring Redis Cache配置
 */
@Configuration
@EnableCaching(proxyTargetClass = true)
@Slf4j
public class SpringRedisCacheConfig {

    private Environment env;

    @Autowired
    public void setEnv(Environment env) {
        this.env = env;
    }

    @Value("#{${spring.cache.redis.initCaches.order-main.timeout}}")
    private Map<String, Duration> initCaches;

    /**
     * 配置Redis缓存管理器的构造器
     * @return
     */
    @Bean
    public RedisCacheManagerBuilderCustomizer myRedisCacheManagerBuilderCustomizer() {
        ObjectMapper om = new ObjectMapper();
        // 指定要序列化的域，field,get和set,以及修饰符范围，ANY是都有包括private和public
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 指定序列化输入的类型
        om.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL);
        // LocalDateTime 序列化配置
        om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        om.registerModule(new JavaTimeModule());
        // Money序列化与反序列化配置
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(Money.class, new MoneyJsonSerializer());
        simpleModule.addDeserializer(Money.class, new MoneyJsonDeserializer());
        om.registerModule(simpleModule);

        // 设置CacheManager的值序列化使用Jackson
        RedisSerializer<Object> jsonSerializer = new GenericJackson2JsonRedisSerializer(om);
        RedisSerializationContext.SerializationPair<Object> pair = RedisSerializationContext
                .SerializationPair.fromSerializer(jsonSerializer);
        RedisCacheConfiguration redisCacheConfig = RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(pair)
                // 默认key超时时间
                .entryTtl(Duration.ofMillis(env.getProperty("spring.cache.redis.time-to-live", Long.class)));

        // 设置缓存名与对应的超时时间
        Set<String> cacheNames = new HashSet<>();
        ConcurrentHashMap<String, RedisCacheConfiguration> cacheConfig = new ConcurrentHashMap<>();
        initCaches.forEach((k, v) -> {
            cacheNames.add(k);
            cacheConfig.put(k, redisCacheConfig.entryTtl(v));
        });

        return builder -> builder
                .withCacheConfiguration(CacheNameConsts.REDIS_CACHE, redisCacheConfig)
                .initialCacheNames(cacheNames)
                .withInitialCacheConfigurations(cacheConfig);
    }

}
