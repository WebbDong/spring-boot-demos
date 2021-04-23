package com.webbdong.springboot.jpa.entity.onetoone;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Webb Dong
 * @date 2018-03-25 3:32 PM
 */
@Getter
@Setter
@Entity
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String pwd;

    private Integer gender;

    private Date birthday;

    private Integer state;

    private Date createdTime;

    private Date updatedTime;

    /**
     * 一对一级联
     * 与 IdCard 一对一
     * 注意双向级联引发的死循环调用问题
     */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idcardId", referencedColumnName = "id")
    private transient IdCard idCard;

}
