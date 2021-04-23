package com.webbdong.springboot.mvc.enums;

/**
 * 枚举 JSON 序列化显示器
 * @author Webb Dong
 * @date 2021-04-23 5:07 PM
 */
public interface EnumJsonSerializableDisplay {

    /**
     * 此方法返回的值，在序列化成 json 时会使用
     */
    String display();

}
