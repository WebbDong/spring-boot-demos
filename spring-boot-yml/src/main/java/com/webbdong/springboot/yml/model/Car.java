package com.webbdong.springboot.yml.model;

import lombok.Data;

/**
 * @author Webb Dong
 * @date 2021-04-20 5:28 PM
 */
@Data
public class Car {

    private Integer power;

    private String brand;

    public Integer drive() {
        return power;
    }

}
