package com.webbdong.springboot.neo4j.entity.relationship;

import com.webbdong.springboot.neo4j.entity.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.util.List;

/**
 * @author Webb Dong
 * @date 2022-07-02 12:45
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString
@RelationshipProperties
public class ActedIn {

    @Id
    @GeneratedValue
    private Long id;

    @TargetNode
    private Movie movie;

    /**
     * 角色属性集合
     */
    private List<String> roles;

}

