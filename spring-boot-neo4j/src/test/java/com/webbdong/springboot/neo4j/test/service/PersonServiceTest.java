package com.webbdong.springboot.neo4j.test.service;

import com.webbdong.springboot.neo4j.SpringBootNeo4jApplication;
import com.webbdong.springboot.neo4j.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Webb Dong
 * @date 2022-07-03 00:14
 */
@SpringBootTest(classes = SpringBootNeo4jApplication.class)
public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Test
    public void testSetGender() {
        personService.setGender();
    }

}
