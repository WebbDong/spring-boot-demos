package com.webbdong.springboot.transaction.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {

    private Long id;

    private String userName;

    private String password;

    private LocalDateTime lastLoginTime;

    private Integer sex;

}
