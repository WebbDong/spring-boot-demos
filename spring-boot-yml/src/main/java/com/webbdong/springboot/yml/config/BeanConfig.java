package com.webbdong.springboot.yml.config;

import com.webbdong.springboot.yml.model.Car;
import com.webbdong.springboot.yml.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Webb Dong
 * @date 2021-04-20 5:31 PM
 */
@Configuration
public class BeanConfig {

    @Bean
    public Student student() {
        Student stu = new Student();
        stu.setName("Adam");
        stu.setAge(50);
        stu.setEmail("14567891@gmail.com");
        return stu;
    }

    @Bean
    public Car car() {
        Car car = new Car();
        car.setBrand("Ferrari");
        car.setPower(800);
        return car;
    }

    @Bean
    public List<Student> studentList() {
        List<Student> studentList = new ArrayList<>();
        Student student1 = new Student();
        student1.setName("Lisa");
        student1.setAge(25);
        student1.setEmail("7897465@gmail.com");
        studentList.add(student1);
        Student student2 = new Student();
        student2.setName("John");
        student2.setAge(50);
        student2.setEmail("456789@gmail.com");
        studentList.add(student2);
        Student student3 = new Student();
        student3.setName("Jackson");
        student3.setAge(60);
        student3.setEmail("654987@gmail.com");
        studentList.add(student3);
        Student student4 = new Student();
        student4.setName("Wade");
        student4.setAge(65);
        student4.setEmail("321465789@gmail.com");
        studentList.add(student4);
        return studentList;
    }

}
