package com.webbdong.springboot.mvc.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Webb Dong
 * @date 2021-04-23 4:40 PM
 */
@Getter
@AllArgsConstructor
public enum WeekendEnum implements EnumJsonSerializableDisplay {

    MONDAY("0", "星期一"),
    TUESDAY("1", "星期二"),
    WEDNESDAY("2", "星期三"),
    THURSDAY("3", "星期四"),
    FRIDAY("4", "星期五"),
    SATURDAY("5", "星期六"),
    SUNDAY("6", "星期日");

    private String code;

    private String desc;

    @Override
    public String display() {
        return desc;
    }

}
