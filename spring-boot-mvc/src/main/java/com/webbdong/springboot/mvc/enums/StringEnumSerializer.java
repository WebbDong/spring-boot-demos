package com.webbdong.springboot.mvc.enums;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.webbdong.springboot.mvc.jackson.StringEnumJsonSerializer;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 将枚举的 String 类型某个字段原值转换成指定的值
 * @author Webb Dong
 * @date 2021-04-23 5:27 PM
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@JacksonAnnotationsInside
@JsonSerialize(using = StringEnumJsonSerializer.class)
public @interface StringEnumSerializer {

    /**
     * 枚举类型字节码
     */
    Class<? extends Enum> enumClass();

    /**
     * 需要在序列化为 json 时，取哪个枚举字段来赋值
     */
    String displayFieldName() default "";

}
