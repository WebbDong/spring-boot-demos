package com.webbdong.springboot.mybatis.entity.onetomany;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author Webb Dong
 * @date 2018-03-25 3:33 PM
 */
@Getter
@Setter
public class OrderItem {

    private Long id;

    private Long orderId;

    private String orderNo;

    private Long productId;

    private String productName;

    private BigDecimal productPrice;

    private String productQuantity;

    private Order order;

}
