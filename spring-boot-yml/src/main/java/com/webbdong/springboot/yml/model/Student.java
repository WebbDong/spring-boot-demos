package com.webbdong.springboot.yml.model;

import lombok.Data;

/**
 * @author Webb Dong
 * @date 2021-04-20 5:28 PM
 */
@Data
public class Student {

    public static final String CLASS_NAME = "Student";

    private String name;

    private Integer age;

    private String email;

    public Integer addNum(int num1, int num2) {
        return num1 + num2;
    }

}
