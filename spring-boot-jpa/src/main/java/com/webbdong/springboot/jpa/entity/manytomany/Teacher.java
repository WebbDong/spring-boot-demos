package com.webbdong.springboot.jpa.entity.manytomany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "t_teacher")
@JsonIgnoreProperties("studentList")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Date createdTime;

    private Date updatedTime;

    /**
     * 多对多级联
     */
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    // 手动指定中间表的配置方式
    @JoinTable(name = "t_student_teacher", // 中间表的表名
               joinColumns = {@JoinColumn(name = "teacherId")},
               inverseJoinColumns = {@JoinColumn(name = "studentId")})
    private List<Student> studentList;

}
