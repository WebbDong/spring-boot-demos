package com.webbdong.springboot.redis.cache.model.mapper.typemapper;

import com.webbdong.springboot.redis.cache.model.vo.MoneyVo;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.util.Objects;

/**
 * OrderMain模型数据类型映射
 */
public class OrderMainModelTypeMapper {

    /**
     * MoneyVo 转换成 joda Money
     */
    public Money asMoney(MoneyVo moneyVo) {
        if (Objects.isNull(moneyVo)) {
            return null;
        }
        return Money.of(CurrencyUnit.of(moneyVo.getCurrency()), moneyVo.getAmount());
    }

}
