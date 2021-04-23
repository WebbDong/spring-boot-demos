package com.webbdong.springboot.mybatis.test;

import com.webbdong.springboot.mybatis.entity.manytomany.Student;
import com.webbdong.springboot.mybatis.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

/**
 * @author Webb Dong
 * @date 2021-04-23 2:39 PM
 */
@SpringBootTest
public class StudentMapperTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void testSelectCascadeById() {
        Optional<Student> optionalStudent = studentMapper.selectCascadeById(1L);
        optionalStudent.ifPresent(student -> System.out.println(optionalStudent));
    }

}
