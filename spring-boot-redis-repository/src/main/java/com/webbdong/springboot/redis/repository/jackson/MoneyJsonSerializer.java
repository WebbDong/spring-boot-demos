package com.webbdong.springboot.redis.repository.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.joda.money.Money;

import java.io.IOException;

public class MoneyJsonSerializer extends JsonSerializer<Money> {

    @Override
    public void serialize(Money value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("amount", value.getAmount().toString());
        gen.writeStringField("currency", value.getCurrencyUnit().getCode());
        gen.writeEndObject();
    }

}
