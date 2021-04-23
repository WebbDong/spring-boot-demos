package com.webbdong.springboot.jpa.test;

import com.google.gson.Gson;
import com.webbdong.springboot.jpa.entity.onetomany.Order;
import com.webbdong.springboot.jpa.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

/**
 * @author Webb Dong
 * @date 2018-04-23 2:11 AM
 */
@SpringBootTest
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private Gson gson;

    @Test
    public void testFindById() {
        Optional<Order> optionalOrder = orderRepository.findById(9002L);
        optionalOrder.ifPresent(order -> {
            System.out.println(order);
            System.out.println(gson.toJson(order));
        });
    }

}
