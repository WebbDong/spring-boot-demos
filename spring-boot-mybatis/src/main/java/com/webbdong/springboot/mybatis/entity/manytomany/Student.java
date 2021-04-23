package com.webbdong.springboot.mybatis.entity.manytomany;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * @author Webb Dong
 * @date 2018-04-23 11:07 AM
 */
@Getter
@Setter
public class Student {

    private Long id;

    private String name;

    private Date createdTime;

    private Date updatedTime;

    /**
     * 多对多级联
     */
    private List<Teacher> teacherList;

}
