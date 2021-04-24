package com.webbdong.springboot.redis.test;

import com.google.gson.Gson;
import com.webbdong.springboot.redis.model.Coffee;
import com.webbdong.springboot.redis.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.SerializationUtils;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.time.LocalDateTime;

/**
 * Jedis demo
 */
@SpringBootTest
@Slf4j
public class JedisTest {

    @Autowired
    private JedisPool jedisPool;

    @Test
    public void testSet() {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.set("test1", "Ferrari");

            Coffee coffee = Coffee.builder()
                    .id("5f3284a7c602911875c81306")
                    .name("Latte")
                    .price(Money.of(CurrencyUnit.of("CNY"), 89.99))
                    .createTime(LocalDateTime.now())
                    .updateTime(LocalDateTime.now())
                    .build();
            jedis.set("Latte".getBytes(), SerializationUtils.serialize(coffee));
            jedis.expire("Latte", 30);

            Product product = Product.builder()
                    .id(5L)
                    .name("Ferrari")
                    .price(Money.of(CurrencyUnit.USD, 300000))
                    .createTime(LocalDateTime.now())
                    .updateTime(LocalDateTime.now())
                    .build();
            Gson gson = new Gson();
            jedis.set("product", gson.toJson(product));
        }
    }

    @Test
    public void testGet() {
        try (Jedis jedis = jedisPool.getResource()) {
            String value1 = jedis.get("test1");
            log.info("value1 = {}", value1);

            byte[] objBytes = jedis.get("Latte".getBytes());
            if (objBytes != null) {
                Coffee coffee1 = SerializationUtils.deserialize(objBytes);
                log.info("coffee1 = {}", coffee1);
            }

            String productJson = jedis.get("product");
            Gson gson = new Gson();
            Product product1 = gson.fromJson(productJson, Product.class);
            log.info("product1 = {}", product1);
        }
    }

}
