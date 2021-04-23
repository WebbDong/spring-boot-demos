package com.webbdong.springboot.jpa.repository;

import com.webbdong.springboot.jpa.entity.manytomany.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Webb Dong
 * @date 2021-04-23 12:44 PM
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
}
