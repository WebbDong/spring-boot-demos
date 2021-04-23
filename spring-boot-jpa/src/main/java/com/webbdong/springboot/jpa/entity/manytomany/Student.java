package com.webbdong.springboot.jpa.entity.manytomany;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * @author Webb Dong
 * @date 2018-04-23 11:07 AM
 */
@Getter
@Setter
@Entity
@Table(name = "t_student")
//@JsonIgnoreProperties("teacherList")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Date createdTime;

    private Date updatedTime;

    /**
     * 多对多级联
     */
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "studentList")
    private List<Teacher> teacherList;

}
