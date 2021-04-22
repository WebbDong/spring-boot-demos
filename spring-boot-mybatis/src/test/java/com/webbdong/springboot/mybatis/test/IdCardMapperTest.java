package com.webbdong.springboot.mybatis.test;

import com.webbdong.springboot.mybatis.entity.IdCard;
import com.webbdong.springboot.mybatis.mapper.IdCardMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Webb Dong
 * @date 2018-04-22 7:01 PM
 */
@SpringBootTest
public class IdCardMapperTest {

    @Autowired
    private IdCardMapper idCardMapper;

    @Test
    public void testSelectCascadeById() {
        IdCard idCard = idCardMapper.selectCascadeById(1L);
        System.out.println(idCard);
    }

}
