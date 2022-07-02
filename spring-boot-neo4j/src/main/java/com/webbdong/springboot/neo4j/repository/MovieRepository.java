package com.webbdong.springboot.neo4j.repository;

import com.webbdong.springboot.neo4j.entity.Movie;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Webb Dong
 * @date 2022-07-02 14:01
 */
@Repository
public interface MovieRepository extends Neo4jRepository<Movie, Long> {
}
