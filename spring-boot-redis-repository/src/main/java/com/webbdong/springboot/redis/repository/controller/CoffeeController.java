package com.webbdong.springboot.redis.repository.controller;

import com.webbdong.springboot.redis.repository.model.Coffee;
import com.webbdong.springboot.redis.repository.repository.CoffeeRedisRepository;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author Webb Dong
 * @date 2021-04-24 8:34 PM
 */
@RestController
public class CoffeeController {

    private CoffeeRedisRepository coffeeRedisRepository;

    @Autowired
    public CoffeeController(CoffeeRedisRepository coffeeRedisRepository) {
        this.coffeeRedisRepository = coffeeRedisRepository;
    }

    @PostMapping("/coffee")
    public Coffee getCoffee(@RequestParam("id") String id) {
        Optional<Coffee> optionalCoffee = coffeeRedisRepository.findById(id);
        return optionalCoffee.isPresent() ? optionalCoffee.get() : null;
    }

    @PostMapping("/save")
    public String saveCoffee(@RequestBody Coffee coffee) {
        coffeeRedisRepository.save(Coffee.builder()
                .id("5f3284a7c602911875c123456")
                .name(coffee.getName())
                .price(coffee.getPrice())
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build());
        return "success";
    }

}
