package com.webbdong.springboot.mybatis.test;

import com.webbdong.springboot.mybatis.entity.Order;
import com.webbdong.springboot.mybatis.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author Webb Dong
 * @date 2021-04-20 8:33 PM
 */
@SpringBootTest
public class OrderMapperTest {

    private OrderMapper orderMapper;

    @Autowired
    public OrderMapperTest(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Test
    public void testSelectLikeOrderNo1() {
        List<Order> orderList = orderMapper.selectLikeOrderNo1("%93161413%");
        System.out.println(orderList.size());
        System.out.println(orderList);
    }

    @Test
    public void testSelectLikeOrderNo2() {
        List<Order> orderList = orderMapper.selectLikeOrderNo2("93161413");
        System.out.println(orderList.size());
        System.out.println(orderList);
    }

    @Test
    public void testSelectLikeOrderNo3() {
        List<Order> orderList = orderMapper.selectLikeOrderNo3("93161413");
        System.out.println(orderList.size());
        System.out.println(orderList);
    }

}
