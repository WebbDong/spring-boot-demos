package com.webbdong.springboot.redis.test;

import com.webbdong.springboot.redis.model.Coffee;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * RedisTemplate demo
 * spring data redis默认使用Lettuce客户端
 */
@SpringBootTest
@Slf4j
public class RedisTemplateTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void testSet() {
        redisTemplate.opsForValue().set("test", "Lamborghini");

        Coffee coffee = Coffee.builder()
                .id("5f3284a7c602911875c81307")
                .name("Latte")
                .price(Money.of(CurrencyUnit.of("CNY"), 89.99))
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();
        redisTemplate.opsForValue().set("Latte", coffee);
        redisTemplate.expire("Latte", 5, TimeUnit.MINUTES);
    }

    @Test
    public void testGet() {
        String value1 = (String) redisTemplate.opsForValue().get("test");
        log.info("value1 = {}", value1);

        Coffee coffee = (Coffee) redisTemplate.opsForValue().get("Latte");
        log.info("coffee = {}", coffee);
    }

}
