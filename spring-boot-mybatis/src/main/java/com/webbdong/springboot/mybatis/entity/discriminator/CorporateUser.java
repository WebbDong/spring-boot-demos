package com.webbdong.springboot.mybatis.entity.discriminator;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 公司用户
 * @author Webb Dong
 * @date 2018-04-23 3:46 PM
 */
@Getter
@Setter
public class CorporateUser implements VehicleOwner {

    private Long id;

    private String name;

    private Date createdTime;

    private Date updatedTime;

}
