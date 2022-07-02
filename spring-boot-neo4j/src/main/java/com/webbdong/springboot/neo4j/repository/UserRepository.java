package com.webbdong.springboot.neo4j.repository;

import com.webbdong.springboot.neo4j.entity.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Webb Dong
 * @date 2022-07-02 16:43
 */
@Repository
public interface UserRepository extends Neo4jRepository<User, Long> {

    // 无法级联映射
    @Query("MATCH p = (u:User {name:$name})-[r:Follow*1..2]->(:User) RETURN u, collect(nodes(p)), collect(relationships(p))")
    User findByNameWithDepth(@Param("name") String name);

}
