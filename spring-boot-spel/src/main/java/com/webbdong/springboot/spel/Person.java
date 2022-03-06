package com.webbdong.springboot.spel;

import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * @author Webb Dong
 * @date 2022-03-06 12:14 PM
 */
@SuperBuilder
@Data
public class Person {

    private String name;

    private Integer age;

}
