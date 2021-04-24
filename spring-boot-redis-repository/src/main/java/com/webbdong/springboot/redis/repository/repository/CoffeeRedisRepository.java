package com.webbdong.springboot.redis.repository.repository;

import com.webbdong.springboot.redis.repository.model.Coffee;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CoffeeRedisRepository extends CrudRepository<Coffee, String> {

    // 根据 name 字段来查询时，在 Coffee 模型中的 name 字段必须加上注解 @Indexed
    Optional<Coffee> findOneByName(String name);

}
