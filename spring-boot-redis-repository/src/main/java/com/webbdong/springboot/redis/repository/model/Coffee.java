package com.webbdong.springboot.redis.repository.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.webbdong.springboot.redis.repository.jackson.MoneyJsonDeserializer;
import com.webbdong.springboot.redis.repository.jackson.MoneyJsonSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.money.Money;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@RedisHash(value = "coffee", timeToLive = 120)
public class Coffee {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Indexed
    private String name;

    @JsonSerialize(using = MoneyJsonSerializer.class)
    @JsonDeserialize(using = MoneyJsonDeserializer.class)
    private Money price;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
