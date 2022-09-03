package com.webbdong.springboot.neo4j.entity;

import com.webbdong.springboot.neo4j.entity.relationship.Follow;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

/**
 * @author Webb Dong
 * @date 2022-07-02 16:35
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString
@Node("User")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public User(String name) {
        this.name = name;
    }

    @Relationship(type = "Follow", direction = Relationship.Direction.OUTGOING)
    private List<Follow> follows;

    @Relationship(type = "Follow", direction = Relationship.Direction.INCOMING)
    private List<Follow> fans;

}
