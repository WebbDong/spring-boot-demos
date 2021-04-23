package com.webbdong.springboot.mybatis.mapper;

import com.webbdong.springboot.mybatis.entity.manytomany.Teacher;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.Optional;

/**
 * @author Webb Dong
 * @date 2018-04-23 2:27 PM
 */
@Mapper
public interface TeacherMapper {

    @Select("SELECT * FROM t_teacher WHERE id = #{0}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "studentList",
                    column = "id",
                    many = @Many(fetchType = FetchType.LAZY,
                                 select = "com.webbdong.springboot.mybatis.mapper.StudentTeacherRelationMapper.selectStudentsByTeacherId"))
    })
    Optional<Teacher> selectCascadeById(Long id);

}
