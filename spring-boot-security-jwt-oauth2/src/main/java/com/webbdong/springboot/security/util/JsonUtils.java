package com.webbdong.springboot.security.util;

import com.google.gson.Gson;

/**
 * JSON 工具类
 * @author: Webb Dong
 * @date: 2021-07-27 3:54 PM
 */
public class JsonUtils {

    private static final Gson GSON = new Gson();

    public static String toJSONString(Object obj) {
        return GSON.toJson(obj);
    }

    public static <T> T parseObj(String json, Class<T> clazz) {
        return GSON.fromJson(json, clazz);
    }

    private JsonUtils() {}

}
