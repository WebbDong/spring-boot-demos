package com.webbdong.springboot.jpa.repository;

import com.webbdong.springboot.jpa.entity.onetomany.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Webb Dong
 * @date 2018-04-23 1:44 AM
 */
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
