package com.webbdong.springboot.bean.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Webb Dong
 * @date 2021-04-16 5:49 PM
 */
@Getter
@Setter
public class Student extends Person {

    private Float score;

    public Student(String name, float score) {
        super(name);
        this.score = score;
    }

}
