package com.webbdong.springboot.neo4j.entity.relationship;

import com.webbdong.springboot.neo4j.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

/**
 * @author Webb Dong
 * @date 2022-07-02 16:36
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString
@RelationshipProperties
public class Follow {

    @Id
    @GeneratedValue
    private Long id;

    @TargetNode
    private User follower;

}
