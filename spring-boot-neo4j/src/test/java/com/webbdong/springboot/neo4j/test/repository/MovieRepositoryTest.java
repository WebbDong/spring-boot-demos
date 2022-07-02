package com.webbdong.springboot.neo4j.test.repository;

import com.webbdong.springboot.neo4j.SpringBootNeo4jApplication;
import com.webbdong.springboot.neo4j.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Webb Dong
 * @date 2022-07-02 14:38
 */
@SpringBootTest(classes = SpringBootNeo4jApplication.class)
public class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

}
