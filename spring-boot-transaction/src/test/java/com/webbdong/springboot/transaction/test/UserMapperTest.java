package com.webbdong.springboot.transaction.test;

import com.webbdong.springboot.transaction.entity.User;
import com.webbdong.springboot.transaction.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Webb Dong
 * @date 2021-04-21 12:01 AM
 */
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectById() {
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

}
