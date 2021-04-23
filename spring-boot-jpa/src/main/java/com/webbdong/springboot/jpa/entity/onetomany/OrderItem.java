package com.webbdong.springboot.jpa.entity.onetomany;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author Webb Dong
 * @date 2018-03-25 3:33 PM
 */
@Getter
@Setter
@Entity
@Table(name = "t_order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderNo;

    private Long productId;

    private String productName;

    private BigDecimal productPrice;

    private String productQuantity;

    /**
     * 多对一级联
     * 注意双向级联引发的死循环调用问题
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "orderId", referencedColumnName = "id")
    private transient Order order;

}
