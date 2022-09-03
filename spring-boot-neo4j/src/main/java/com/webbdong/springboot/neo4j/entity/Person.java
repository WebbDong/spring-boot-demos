package com.webbdong.springboot.neo4j.entity;

import com.webbdong.springboot.neo4j.entity.relationship.ActedIn;
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
 * @date 2022-07-02 12:30
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString
@Node("Person")
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer born;

    private String gender;

    @Relationship(type = "ACTED_IN")
    private List<ActedIn> actedIns;

}
