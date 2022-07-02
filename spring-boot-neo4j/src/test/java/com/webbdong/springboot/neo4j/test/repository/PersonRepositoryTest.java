package com.webbdong.springboot.neo4j.test.repository;

import com.webbdong.springboot.neo4j.SpringBootNeo4jApplication;
import com.webbdong.springboot.neo4j.entity.Movie;
import com.webbdong.springboot.neo4j.entity.Person;
import com.webbdong.springboot.neo4j.entity.relationship.ActedIn;
import com.webbdong.springboot.neo4j.repository.PersonRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

/**
 * @author Webb Dong
 * @date 2022-07-02 14:06
 */
@SpringBootTest(classes = SpringBootNeo4jApplication.class)
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void testSave() {
        Person p = new Person();
        p.setBorn(1991);
        p.setName("WebbDong");

/*        p.setActedIns(Lists.newArrayList(ActedIn.builder()
                .roles(Lists.newArrayList("陆志廉"))
                .movie(Movie.builder()
                        .title("反贪风暴3")
                        .released(2018)
                        .tagLine("abcdefg")
                        .build())
                .build()));*/

        personRepository.save(p);
    }

    @Test
    public void testFindById() {
        Optional<Person> p = personRepository.findById(364L);
        if (p.isPresent()) {
            System.out.println(p.get());
        }
    }

    @Test
    public void testFindByName() {
        Optional<Person> p = personRepository.findByName("WebbDong");
        if (p.isPresent()) {
            System.out.println(p.get());
        }
    }

    @Test
    public void test() {
        Optional<Person> p = personRepository.findByIdWithDepth(264L);
        if (p.isPresent()) {
            System.out.println(p.get());
        }
    }

}
