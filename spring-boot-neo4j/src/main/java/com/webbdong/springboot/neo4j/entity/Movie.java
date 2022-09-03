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
import org.springframework.data.neo4j.core.schema.Property;
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
@Node("Movie")
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private Integer released;

    @Property("tagline")
    private String tagLine;

    @Relationship(type = "ACTED_IN", direction = Relationship.Direction.INCOMING)
    private List<ActedIn> actedIns;

}
