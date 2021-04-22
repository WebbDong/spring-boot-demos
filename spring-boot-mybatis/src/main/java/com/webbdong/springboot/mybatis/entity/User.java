package com.webbdong.springboot.mybatis.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Webb Dong
 * @date 2018-03-25 3:32 PM
 */
@Getter
@Setter
public class User {

    private Long id;

    private String username;

    private String pwd;

    private Integer gender;

    private Date birthday;

    private Integer state;

    private Date createdTime;

    private Date updatedTime;

    private Long idcardId;

    private IdCard idCard;

}
