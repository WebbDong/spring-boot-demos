package com.webbdong.springboot.neo4j.test.repository;

import com.webbdong.springboot.neo4j.SpringBootNeo4jApplication;
import com.webbdong.springboot.neo4j.entity.User;
import com.webbdong.springboot.neo4j.entity.relationship.Follow;
import com.webbdong.springboot.neo4j.repository.UserRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Webb Dong
 * @date 2022-07-02 16:44
 */
@SpringBootTest(classes = SpringBootNeo4jApplication.class)
public class UserRepositoryTest {

    @Test
    public void testSave(@Autowired UserRepository userRepository) {
        User webbDong = new User();
        webbDong.setName("WebbDong");
        webbDong.setFollows(Lists.newArrayList(
                Follow.builder().follower(new User("Kobe")).build(),
                Follow.builder().follower(new User("Curry")).build(),
                Follow.builder().follower(new User("Pagani")).build(),
                Follow.builder().follower(new User("Bugatti")).build()));
        userRepository.save(webbDong);
    }

    @Test
    public void testSave2(@Autowired UserRepository userRepository) {
        User curry = userRepository.findById(368L).get();
        User jordon = User.builder()
                .name("Jordon")
                .build();
        User iverson = User.builder()
                .name("Iverson")
                .build();
        User wade = User.builder()
                .name("Wade")
                .build();
        iverson.setFollows(Lists.newArrayList(Follow.builder().follower(wade).build()));
        jordon.setFollows(Lists.newArrayList(Follow.builder().follower(iverson).build()));
        curry.setFollows(Lists.newArrayList(Follow.builder().follower(jordon).build()));
        userRepository.save(curry);
    }

    @Test
    public void testFindById(@Autowired UserRepository userRepository) {
        User webbDong = userRepository.findById(366L).get();
        System.out.println(webbDong);
    }

    @Test
    public void testFindByNameWithDepth(@Autowired UserRepository userRepository) {
        User webbDong = userRepository.findByNameWithDepth("WebbDong");
        System.out.println(webbDong);
    }

}
