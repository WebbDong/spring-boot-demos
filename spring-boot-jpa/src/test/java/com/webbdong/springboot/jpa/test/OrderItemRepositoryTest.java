package com.webbdong.springboot.jpa.test;

import com.google.gson.Gson;
import com.webbdong.springboot.jpa.entity.onetomany.OrderItem;
import com.webbdong.springboot.jpa.repository.OrderItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

/**
 * @author Webb Dong
 * @date 2018-04-23 2:11 AM
 */
@SpringBootTest
public class OrderItemRepositoryTest {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private Gson gson;

    @Test
    public void testFindById() {
        Optional<OrderItem> optionalOrderItem = orderItemRepository.findById(1L);
        optionalOrderItem.ifPresent(orderItem -> {
            System.out.println(orderItem);
            System.out.println(gson.toJson(orderItem));
        });
    }

}
