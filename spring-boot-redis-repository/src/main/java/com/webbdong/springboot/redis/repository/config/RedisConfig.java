package com.webbdong.springboot.redis.repository.config;

import com.webbdong.springboot.redis.repository.converter.BytesToMoneyConverter;
import com.webbdong.springboot.redis.repository.converter.MoneyToBytesConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisKeyValueAdapter;
import org.springframework.data.redis.core.convert.RedisCustomConversions;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import java.util.Arrays;

@Configuration
// enableKeyspaceEvents 用于设置 redis key 过期事件的监听，开启后，如果某个 key 过期了，与它相关联的 key 也会一起清除
@EnableRedisRepositories(enableKeyspaceEvents = RedisKeyValueAdapter.EnableKeyspaceEvents.ON_STARTUP)
public class RedisConfig {

    @Bean
    public RedisCustomConversions redisCustomConversions() {
        return new RedisCustomConversions(
                Arrays.asList(new MoneyToBytesConverter(), new BytesToMoneyConverter()));
    }

}
