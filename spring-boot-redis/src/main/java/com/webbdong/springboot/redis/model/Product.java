package com.webbdong.springboot.redis.model;

import lombok.*;
import org.joda.money.Money;

import java.time.LocalDateTime;

/**
 * <p>
 * 商品
 * </p>
 *
 * @author Webb Dong
 * @since 2020-08-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 商品名
     */
    private String name;

    /**
     * 商品价格,单位分
     */
    private Money price;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
