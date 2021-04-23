package com.webbdong.springboot.mybatis.mapper;

import com.webbdong.springboot.mybatis.entity.manytomany.Student;
import com.webbdong.springboot.mybatis.entity.manytomany.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Webb Dong
 * @date 2018-04-23 2:49 PM
 */
@Mapper
public interface StudentTeacherRelationMapper {

    @Select(" SELECT tea.* " +
            " FROM t_teacher tea " +
            " INNER JOIN t_student_teacher stutearel " +
            " ON tea.id = stutearel.teacher_id " +
            " INNER JOIN t_student stu " +
            " ON stu.id = stutearel.student_id " +
            " WHERE stu.id = #{0} ")
    List<Teacher> selectTeachersByStudentId(Long studentId);

    @Select(" SELECT stu.* " +
            " FROM t_student stu " +
            " INNER JOIN t_student_teacher stutearel " +
            " ON stu.id = stutearel.student_id " +
            " INNER JOIN t_teacher tea " +
            " ON tea.id = stutearel.teacher_id " +
            " WHERE tea.id = #{0} ")
    List<Student> selectStudentsByTeacherId(Long teacherId);

}
