package com.webbdong.springboot.mybatis.test;

import com.webbdong.springboot.mybatis.entity.onetoone.User;
import com.webbdong.springboot.mybatis.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Webb Dong
 * @date 2021-04-22 7:02 PM
 */
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectCascadeById() {
        User user = userMapper.selectCascadeById(1L);
        System.out.println(user);
    }

}
