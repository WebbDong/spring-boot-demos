package com.webbdong.springboot.mvc.utils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;

/**
 * @author Webb Dong
 * @date 2021-04-23 9:01 PM
 */
public interface EnumUtils {

    /**
     * 根据枚举的字段值，返回对应的枚举对象
     */
    static Enum valueOf(Class<? extends Enum> enumClass, Object fieldValue) {
        List enumList = org.apache.commons.lang3.EnumUtils.getEnumList(enumClass);
        for (Object enumObj : enumList) {
            Field[] fields = enumClass.getDeclaredFields();
            try {
                for (Field field : fields) {
                    field.setAccessible(true);
                    Object value = field.get(enumObj);
                    if (Objects.equals(value, fieldValue)) {
                        return (Enum) enumObj;
                    }
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

}
