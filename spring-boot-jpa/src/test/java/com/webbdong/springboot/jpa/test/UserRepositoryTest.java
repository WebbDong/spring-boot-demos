package com.webbdong.springboot.jpa.test;

import com.google.gson.Gson;
import com.webbdong.springboot.jpa.entity.onetoone.User;
import com.webbdong.springboot.jpa.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

/**
 * @author Webb Dong
 * @date 2018-04-23 1:48 AM
 */
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Gson gson;

    @Test
    public void testFindById() {
        Optional<User> optionalUser = userRepository.findById(1L);
        optionalUser.ifPresent(user -> {
            System.out.println(user);
            System.out.println(gson.toJson(user));
        });
    }

}
