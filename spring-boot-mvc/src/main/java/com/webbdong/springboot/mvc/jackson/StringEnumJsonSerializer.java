package com.webbdong.springboot.mvc.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.webbdong.springboot.mvc.enums.EnumJsonSerializableDisplay;
import com.webbdong.springboot.mvc.enums.StringEnumSerializer;
import com.webbdong.springboot.mvc.utils.EnumUtils;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.lang.reflect.Field;

/**
 * 将枚举的某个字段原值转换成指定的值
 * @author Webb Dong
 * @date 2021-04-23 7:11 PM
 */
@AllArgsConstructor
@NoArgsConstructor
public class StringEnumJsonSerializer extends JsonSerializer<String> implements ContextualSerializer {

    private StringEnumSerializer stringEnumSerializer;

    @SneakyThrows
    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        Class<? extends Enum> enumClass = stringEnumSerializer.enumClass();
        String displayFieldName = stringEnumSerializer.displayFieldName();
        Enum enumObj = EnumUtils.valueOf(enumClass, value);
        if (StringUtils.isNotBlank(displayFieldName)) {
            Field field = enumClass.getDeclaredField(displayFieldName);
            field.setAccessible(true);
            gen.writeString(field.get(enumObj).toString());
            // 动态添加字段和值
            gen.writeStringField("newField", "800");
        } else if (enumObj instanceof EnumJsonSerializableDisplay) {
            gen.writeString(((EnumJsonSerializableDisplay) enumObj).display());
            // 动态添加字段和值
            gen.writeStringField("newField", "800");
        } else {
            gen.writeString(value);
        }
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property) throws JsonMappingException {
        if (property != null) {
            // 只处理 String 类型并且有 @StringEnumSerializer 注解的字段
            if (String.class.equals(property.getType().getRawClass())) {
                StringEnumSerializer annotation = property.getAnnotation(StringEnumSerializer.class);
                if (annotation == null) {
                    annotation = property.getContextAnnotation(StringEnumSerializer.class);
                }
                if (annotation != null) {
                    return new StringEnumJsonSerializer(annotation);
                }
            }
        }
        return prov.findNullValueSerializer(property);
    }

}
