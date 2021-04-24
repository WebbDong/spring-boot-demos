package com.webbdong.springboot.redis.cache.model.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.webbdong.springboot.redis.cache.base.BaseEntity;
import com.webbdong.springboot.redis.cache.mybatisplus.typehandler.MoneyTypeHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.joda.money.Money;

/**
 * <p>
 * 订单主表
 * </p>
 *
 * @author Webb Dong
 * @since 2020-08-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("order_main")
public class OrderMainDo extends BaseEntity {

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 订单名
     */
    private String name;

    /**
     * 订单金额,单位分
     */
    @TableField(typeHandler = MoneyTypeHandler.class)
    private Money fee;

    /**
     * 货币
     */
    private String currency;

    /**
     * 乐观锁版本
     */
    @Version
    private Integer version;

}
