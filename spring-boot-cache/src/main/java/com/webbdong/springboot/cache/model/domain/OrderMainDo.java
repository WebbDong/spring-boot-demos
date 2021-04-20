package com.webbdong.springboot.cache.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.webbdong.springboot.cache.base.BaseEntity;
import com.webbdong.springboot.cache.mybatisplus.typehandler.MoneyTypeHandler;
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

    private static final long serialVersionUID = 1L;

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
