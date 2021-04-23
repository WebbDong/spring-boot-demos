package com.webbdong.springboot.mybatis.entity.discriminator;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 个人用户
 * @author Webb Dong
 * @date 2018-04-23 3:47 PM
 */
@Getter
@Setter
public class PersonalUser implements VehicleOwner {

    private Long id;

    private String name;

    private Date createdTime;

    private Date updatedTime;

}
