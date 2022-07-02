package com.webbdong.springboot.neo4j.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Webb Dong
 * @date 2022-07-02 14:03
 */
@EnableNeo4jRepositories(basePackages = "com.webbdong.springboot.neo4j.repository")
@EntityScan(basePackages = "com.webbdong.springboot.neo4j.entity")
@EnableTransactionManagement
@Configuration
public class Neo4jConfig {
}
