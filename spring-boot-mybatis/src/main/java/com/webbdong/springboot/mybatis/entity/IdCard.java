package com.webbdong.springboot.mybatis.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Webb Dong
 * @date 2018-03-25 3:33 PM
 */
@Getter
@Setter
public class IdCard {

    private Long id;

    private Long userId;

    private String idNo;

    private Date createdTime;

    private Date updatedTime;

    private User user;

}
