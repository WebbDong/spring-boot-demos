package com.webbdong.springboot.neo4j.test;

import com.google.common.collect.Maps;
import com.webbdong.springboot.neo4j.SpringBootNeo4jApplication;
import com.webbdong.springboot.neo4j.entity.Person;
import com.webbdong.springboot.neo4j.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.neo4j.core.Neo4jTemplate;

import java.util.Map;
import java.util.Optional;

/**
 * @author Webb Dong
 * @date 2022-07-02 16:32
 */
@SpringBootTest(classes = SpringBootNeo4jApplication.class)
public class Neo4jTemplateTest {

    @Autowired
    private Neo4jTemplate neo4jTemplate;

    @Test
    public void testFindById() {
        Optional<Person> tom = neo4jTemplate.findById(264L, Person.class);
        if (tom.isPresent()) {
            System.out.println(tom.get());
        }
    }

    @Test
    public void testFindOne() {
        final String cypher = "MATCH (user:User {name:$name})-[r:Follow*1..2]->(follower:User) " +
                "WITH user, collect({id: id(follower), name: follower.name}) AS followers " +
                "RETURN user { .name, followers: followers }";
        Map<String, Object> parameters = Maps.newHashMap();
        parameters.put("name", "WebbDong");
        Optional<User> u = neo4jTemplate.findOne(cypher, parameters, User.class);
        if (u.isPresent()) {
            System.out.println(u.get());
        }
    }

}
