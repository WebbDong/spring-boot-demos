package com.webbdong.springboot.jdbc.repository;

import com.webbdong.springboot.jdbc.entity.User;

import java.util.List;

/**
 * @author Webb Dong
 * @date 2021-05-11 10:57 PM
 */
public interface UserRepository {

    List<User> findAll();

    User findById(Long id);

    int update(User user);

    int save(User user);

    int deleteById(Long id);

}
