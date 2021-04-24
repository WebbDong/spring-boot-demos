package com.webbdong.springboot.redis.cache.jackson.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.google.gson.Gson;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MoneyJsonDeserializer extends JsonDeserializer<Money> {

    @Override
    public Money deserialize(JsonParser p, DeserializationContext ctx) throws IOException, JsonProcessingException {
        String json = p.getValueAsString();
        Gson gson = new Gson();
        Map map = gson.fromJson(json, HashMap.class);
//        return Money.ofMinor(CurrencyUnit.of((String) map.get("currencyUnitCode")), ((Double) map.get("amount")).longValue());
        return Money.of(CurrencyUnit.of((String) map.get("currencyUnitCode")), (Double) map.get("amount"));
    }

}
