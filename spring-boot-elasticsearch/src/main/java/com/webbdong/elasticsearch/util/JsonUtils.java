package com.webbdong.elasticsearch.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.nio.charset.StandardCharsets;

/**
 * JSON 工具类
 * @author: Webb Dong
 * @date: 2021-07-29 2:29 PM
 */
public class JsonUtils {

    private static final ObjectMapper OBJECT_MAPPER;

    static {
        OBJECT_MAPPER = new ObjectMapper();
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OBJECT_MAPPER.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        OBJECT_MAPPER.registerModule(new JavaTimeModule());
    }

    public static ObjectMapper getObjectMapper() {
        return OBJECT_MAPPER;
    }

    /**
     * 将对象转换成 JSON 字符串
     */
    public static String toJson(Object obj) throws JsonProcessingException {
        return OBJECT_MAPPER.writeValueAsString(obj);
    }

    /**
     * 将对象转换成 JSON 字符串的字节数组
     */
    public static byte[] toJsonBytes(Object obj) throws JsonProcessingException {
        return OBJECT_MAPPER.writeValueAsString(obj).getBytes(StandardCharsets.UTF_8);
    }

    /**
     * 将 JSON 字符串转换成对象
     */
    public static <T> T parseObj(String json, Class<T> clazz) throws JsonProcessingException {
        return OBJECT_MAPPER.readValue(json, clazz);
    }

    /**
     * 将 JSON 字符串转换成复杂对象
     */
    public static <T> T parseObj(String json, TypeReference<T> typeReference) throws JsonProcessingException {
        return OBJECT_MAPPER.readValue(json, typeReference);
    }

    private JsonUtils() {}

}
