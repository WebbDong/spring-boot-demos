package com.webbdong.springboot.bean.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * @author Webb Dong
 * @date 2021-04-16 5:49 PM
 */
@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Car {

    private String brand;

    private Integer power;

    public void engineStart() {
        System.out.println(brand + " : " + power);
    }

}
