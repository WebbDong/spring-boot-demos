
package com.webbdong.springboot.neo4j.service;

import com.webbdong.springboot.neo4j.entity.Person;
import com.webbdong.springboot.neo4j.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Webb Dong
 * @date 2022-07-03 00:02
 */
@RequiredArgsConstructor(onConstructor_={@Autowired})
@Service
public class PersonService {

    private final PersonRepository personRepository;

    private static final String[] GENDER = {"FEMALE", "MALE"};

    @Transactional
    public void setGender() {
        List<Person> allPerson = personRepository.findAll();
        for (Person p : allPerson) {
            p.setGender(GENDER[RandomUtils.nextInt(0, 2)]);
        }
//        int i = 1 / 0;
        personRepository.saveAll(allPerson);
    }

}
