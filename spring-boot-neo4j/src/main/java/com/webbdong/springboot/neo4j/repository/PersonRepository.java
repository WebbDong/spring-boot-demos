package com.webbdong.springboot.neo4j.repository;

import com.webbdong.springboot.neo4j.entity.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Webb Dong
 * @date 2022-07-02 13:58
 */
@Repository
public interface PersonRepository extends Neo4jRepository<Person, Long> {

    Optional<Person> findByName(@Param("name") String name);

    // 无法级联映射
    @Query(value = "MATCH path = (p:Person)-[:ACTED_IN]->(m) WHERE id(p) = $id RETURN p, collect(nodes(path)) AS movies, collect(relationships(path))")
    Optional<Person> findByIdWithDepth(@Param("id") Long id);

}
