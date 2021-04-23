package com.webbdong.springboot.mybatis.test;

import com.webbdong.springboot.mybatis.entity.manytomany.Teacher;
import com.webbdong.springboot.mybatis.mapper.TeacherMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

/**
 * @author Webb Dong
 * @date 2021-04-23 2:39 PM
 */
@SpringBootTest
public class TeacherMapperTest {

    @Autowired
    private TeacherMapper teacherMapper;

    @Test
    public void testSelectCascadeById() {
        Optional<Teacher> optionalTeacher = teacherMapper.selectCascadeById(1L);
        optionalTeacher.ifPresent(teacher -> System.out.println(teacher));
    }

}
