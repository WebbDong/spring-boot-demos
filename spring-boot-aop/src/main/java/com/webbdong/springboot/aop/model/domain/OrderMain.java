package com.webbdong.springboot.aop.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.webbdong.springboot.aop.mybatisplus.MoneyTypeHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.joda.money.Money;

import java.time.LocalDateTime;

/**
 * <p>
 * 订单主表
 * </p>
 *
 * @author Webb Dong
 * @since 2020-08-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OrderMain {

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
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 逻辑删除,1删除、0未删除
     */
    @TableLogic
    private Integer deleted;

}
