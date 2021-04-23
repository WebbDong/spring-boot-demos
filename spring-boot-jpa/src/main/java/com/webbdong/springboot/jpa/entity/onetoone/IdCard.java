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
 * @date 2018-03-25 3:33 PM
 */
@Getter
@Setter
@Entity
@Table(name = "t_id_card")
public class IdCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String idNo;

    private Date createdTime;

    private Date updatedTime;

    /**
     * 一对一级联
     * 与 User 一对一
     * 注意双向级联引发的死循环调用问题
     */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    // IdCard 的 userId 与 User 的 id 进行关联
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;

}
