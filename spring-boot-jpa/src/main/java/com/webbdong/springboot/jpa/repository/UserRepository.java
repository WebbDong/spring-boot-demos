package com.webbdong.springboot.jpa.repository;

import com.webbdong.springboot.jpa.entity.onetoone.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Webb Dong
 * @date 2018-04-23 1:43 AM
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
