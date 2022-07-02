package com.webbdong.springboot.neo4j.repository;

import com.webbdong.springboot.neo4j.entity.relationship.ActedIn;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Webb Dong
 * @date 2022-07-02 14:01
 */
@Repository
public interface ActedInRepository extends Neo4jRepository<ActedIn, Long> {
}
