package com.webbdong.springboot.jdbc.test;

import com.webbdong.springboot.jdbc.entity.User;
import com.webbdong.springboot.jdbc.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Webb Dong
 * @date 2021-05-11 11:37 PM
 */
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindAll() {
        List<User> userList = userRepository.findAll();
        System.out.println(userList);
    }

    @Test
    public void testFindById() {
        User user = userRepository.findById(1L);
        System.out.println(user);
    }

    @Test
    public void testUpdate() {
        int r = userRepository.update(User.builder()
                .id(2L)
                .userName("Adam")
                .password("4444")
                .build());
        System.out.println(r);
    }

    @Test
    public void testSave() {
        int r = userRepository.save(User.builder()
                .userName("John")
                .password("8888")
                .lastLoginTime(LocalDateTime.now())
                .build());
        System.out.println(r);
    }

    @Test
    public void testDeleteById() {
        int r = userRepository.deleteById(6L);
        System.out.println(r);
    }

}
