package com.webbdong.springboot.mvc.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.webbdong.springboot.mvc.enums.EnumJsonSerializableDisplay;
import com.webbdong.springboot.mvc.jackson.EnumTypeJsonSerializer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * @author Webb Dong
 * @date 2021-04-23 5:01 PM
 */
@Configuration
public class JacksonConfig {

    @Bean
    @Primary
    @ConditionalOnMissingBean(ObjectMapper.class)
    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.build();
        SimpleModule enumHandlerModule = new SimpleModule();
        enumHandlerModule.addSerializer(EnumJsonSerializableDisplay.class, enumTypeJsonSerializer());
        objectMapper.registerModule(enumHandlerModule);
        return objectMapper;
    }

    @Bean
    public EnumTypeJsonSerializer enumTypeJsonSerializer() {
        return new EnumTypeJsonSerializer();
    }

}
