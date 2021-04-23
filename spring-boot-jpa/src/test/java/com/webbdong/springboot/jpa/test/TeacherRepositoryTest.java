package com.webbdong.springboot.jpa.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webbdong.springboot.jpa.entity.manytomany.Teacher;
import com.webbdong.springboot.jpa.repository.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

/**
 * @author Webb Dong
 * @date 2021-04-23 12:44 PM
 */
@SpringBootTest
public class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testFindById() {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(1L);
        optionalTeacher.ifPresent(teacher -> {
            System.out.println(teacher);
            try {
                System.out.println(objectMapper.writeValueAsString(teacher));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });
    }

}
