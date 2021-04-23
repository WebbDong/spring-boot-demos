package com.webbdong.springboot.jpa.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webbdong.springboot.jpa.entity.manytomany.Student;
import com.webbdong.springboot.jpa.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

/**
 * @author Webb Dong
 * @date 2021-04-23 12:45 PM
 */
@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testFindById() {
        Optional<Student> optionalStudent = studentRepository.findById(1L);
        optionalStudent.ifPresent(student -> {
            System.out.println(student);
            try {
                System.out.println(objectMapper.writeValueAsString(student));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });
    }

}
