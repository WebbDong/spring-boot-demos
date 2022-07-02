package com.webbdong.springboot.neo4j.test;

import com.webbdong.springboot.neo4j.SpringBootNeo4jApplication;
import com.webbdong.springboot.neo4j.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.neo4j.driver.Value;
import org.neo4j.driver.types.TypeSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.neo4j.core.Neo4jClient;

import java.util.Map;

/**
 * @author Webb Dong
 * @date 2022-07-02 15:27
 */
@SpringBootTest(classes = SpringBootNeo4jApplication.class)
public class Neo4jClientTest {

    @Autowired
    private Neo4jClient neo4jClient;

    @Test
    public void testFindByNameWithDepth() {
        UserDto dto = neo4jClient
                .query(
                        "MATCH (user:User {name:$name})-[r:Follow*1..2]->(follower:User) " +
                                "WITH user, collect({id: id(follower), name: follower.name}) AS followers " +
                                "RETURN user { .name, followers: followers }")
                .bindAll(Map.of("name", "WebbDong"))
                .fetchAs(UserDto.class)
                .mappedBy(this::toUserDto)
                .one()
                .orElse(null);
        System.out.println(dto);
    }

    private UserDto toUserDto(TypeSystem ignored, org.neo4j.driver.Record record) {
        Value user = record.get("user");
        return UserDto.builder()
                .name(user.get("name").asString())
                .followers(user.get("followers").asList((member) -> UserDto.builder()
                        .id(member.get("id").asLong())
                        .name(member.get("name").asString())
                        .build()))
                .build();
    }

}
