package com.webbdong.springboot.jpa.entity.any;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.MetaValue;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.util.Date;

/**
 * 载具
 * @author Webb Dong
 * @date 2018-04-23 3:48 PM
 */
@Getter
@Setter
@Entity
@Table(name = "t_vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;

    private String model;

    private String ownerType;

    private Long ownerId;

    private Date createdTime;

    private Date updatedTime;

    /**
     * owner 可以是 PersonalUser 也可以是 CorporateUser
     * 类似于 mybatis 的
     */
    @Any(metaColumn = @Column(name = "ownerType"), fetch = FetchType.LAZY)
    @AnyMetaDef(
        idType = "long",
        metaType = "string",
        metaValues = {
            @MetaValue(value = "pu", targetEntity = PersonalUser.class),
            @MetaValue(value = "cu", targetEntity = CorporateUser.class)
        }
    )
    @JoinColumn(name = "ownerId", insertable = false, updatable = false)
    private VehicleOwner owner;

}
