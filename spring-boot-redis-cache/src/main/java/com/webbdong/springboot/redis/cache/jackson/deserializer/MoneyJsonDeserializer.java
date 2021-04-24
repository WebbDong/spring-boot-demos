package com.webbdong.springboot.redis.cache.jackson.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.webbdong.springboot.redis.cache.model.vo.MoneyVo;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.io.IOException;

public class MoneyJsonDeserializer extends JsonDeserializer<Money> {

    @Override
    public Money deserialize(JsonParser p, DeserializationContext ctx) throws IOException, JsonProcessingException {
        ObjectCodec codec = p.getCodec();
        JsonNode jsonNode = codec.readTree(p);
        MoneyVo moneyVo = codec.treeToValue(jsonNode, MoneyVo.class);
        return Money.of(CurrencyUnit.of(moneyVo.getCurrency()), moneyVo.getAmount());
    }

}
