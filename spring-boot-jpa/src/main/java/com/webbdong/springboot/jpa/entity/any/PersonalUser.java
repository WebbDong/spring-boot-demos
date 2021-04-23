package com.webbdong.springboot.jpa.entity.any;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 个人用户
 * @author Webb Dong
 * @date 2018-04-23 3:47 PM
 */
@Getter
@Setter
@Entity
@Table(name = "t_personal_user")
@DiscriminatorValue("pu")
public class PersonalUser implements VehicleOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Date createdTime;

    private Date updatedTime;

}
