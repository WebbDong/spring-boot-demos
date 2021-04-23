package com.webbdong.springboot.mvc.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.webbdong.springboot.mvc.enums.EnumJsonSerializableDisplay;

import java.io.IOException;

/**
 * 通用枚举类型序列化器
 * @author Webb Dong
 * @date 2021-04-23 4:48 PM
 */
public class EnumTypeJsonSerializer extends JsonSerializer<EnumJsonSerializableDisplay> {

    @Override
    public void serialize(EnumJsonSerializableDisplay value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(value.display());
    }

}
