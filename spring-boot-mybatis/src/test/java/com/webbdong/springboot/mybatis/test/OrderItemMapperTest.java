package com.webbdong.springboot.mybatis.test;

import com.webbdong.springboot.mybatis.entity.OrderItem;
import com.webbdong.springboot.mybatis.mapper.OrderItemMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Webb Dong
 * @date 2018-04-22 5:39 PM
 */
@SpringBootTest
public class OrderItemMapperTest {

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Test
    public void testSelectCascadeById() {
        OrderItem orderItem = orderItemMapper.selectCascadeById(1L);
        System.out.println(orderItem);
    }

    @Test
    public void testSelectCascadeByIdAnnotation() {
        OrderItem orderItem = orderItemMapper.selectCascadeByIdAnnotation(2L);
        System.out.println(orderItem);
    }

}
