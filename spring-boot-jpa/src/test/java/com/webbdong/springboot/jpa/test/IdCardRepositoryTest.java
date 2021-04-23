package com.webbdong.springboot.jpa.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.webbdong.springboot.jpa.entity.onetoone.IdCard;
import com.webbdong.springboot.jpa.repository.IdCardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

/**
 * @author Webb Dong
 * @date 2018-04-22 11:11 PM
 */
@SpringBootTest
public class IdCardRepositoryTest {

    @Autowired
    private IdCardRepository idCardRepository;

    @Autowired
    private Gson gson;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testFindById() {
        System.out.println(idCardRepository);
        Optional<IdCard> optionalIdCard = idCardRepository.findById(1L);
        optionalIdCard.ifPresent(idCard -> {
            System.out.println(idCard.getUser());
            try {
                System.out.println(objectMapper.writeValueAsString(idCard));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            System.out.println(gson.toJson(idCard));
        });
    }

}
