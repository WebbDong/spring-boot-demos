package com.webbdong.springboot.yml.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "person")
public class Person {

    private String name;

    private Integer age;

    private List<String> languages;

    private Map<String, String> mapData;

}
