package com.webbdong.springboot.mvc.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Webb Dong
 * @date 2021-04-23 8:27 PM
 */
@AllArgsConstructor
@Getter
public enum GenderEnum {

    MALE(0, "男"),
    FEMALE(1, "女");

    private int code;

    // 指定了 @JsonValue 注解的字段，序列化为 json 时将会使用此字段
    // 可以不需要自定义枚举序列化器
    @JsonValue
    private String desc;

}
