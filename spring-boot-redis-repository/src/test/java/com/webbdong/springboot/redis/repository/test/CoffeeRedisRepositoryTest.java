package com.webbdong.springboot.redis.repository.test;

import com.webbdong.springboot.redis.repository.model.Coffee;
import com.webbdong.springboot.redis.repository.repository.CoffeeRedisRepository;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
@Slf4j
public class CoffeeRedisRepositoryTest {

    @Autowired
    private CoffeeRedisRepository coffeeRedisRepository;

    @Test
    public void testSave() {
        coffeeRedisRepository.save(Coffee.builder()
                .id("5f3284a7c602911875c123456")
                .name("Cappuccino")
                .price(Money.of(CurrencyUnit.of("CNY"), 40.99))
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build());
    }

    @Test
    public void testFindById() {
        Optional<Coffee> optionalCoffee = coffeeRedisRepository.findById("5f3284a7c602911875c123456");
        log.info("coffee = {}", optionalCoffee.get());
    }

    @Test
    public void testFindOneByName() {
        Optional<Coffee> optionalCoffee = coffeeRedisRepository.findOneByName("Cappuccino");
        log.info("coffee = {}", optionalCoffee.get());
    }

}
