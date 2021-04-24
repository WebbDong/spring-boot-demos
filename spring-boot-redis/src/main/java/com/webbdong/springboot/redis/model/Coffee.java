package com.webbdong.springboot.redis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.money.Money;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coffee implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

//    @JsonSerialize(using = MoneyJsonSerializer.class)
//    @JsonDeserialize(using = MoneyJsonDeserializer.class)
    private Money price;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
