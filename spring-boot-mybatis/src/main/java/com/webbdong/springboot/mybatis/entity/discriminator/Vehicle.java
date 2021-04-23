package com.webbdong.springboot.mybatis.entity.discriminator;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 载具
 * @author Webb Dong
 * @date 2018-04-23 3:48 PM
 */
@Getter
@Setter
public class Vehicle {

    private Long id;

    private String brand;

    private String model;

    private String ownerType;

    private Long ownerId;

    private Date createdTime;

    private Date updatedTime;

    /**
     * 可以是 PersonalUser 也可以是 CorporateUser
     */
    private VehicleOwner owner;

}
