package com.webbdong.springboot.cache.model.mapper.typemapper;

import com.webbdong.springboot.cache.model.vo.MoneyVo;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.util.Objects;

/**
 * OrderMain模型数据类型映射
 */
public class OrderMainModelTypeMapper {

    public Money asMoney(MoneyVo moneyVo) {
        if (Objects.isNull(moneyVo)) {
            return null;
        }
        return Money.of(CurrencyUnit.of(moneyVo.getCurrency()), moneyVo.getAmount());
    }

}
