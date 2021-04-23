package com.webbdong.springboot.mybatis.mapper;

import com.webbdong.springboot.mybatis.entity.onetoone.IdCard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

/**
 * @author Webb Dong
 * @date 2018-04-22 3:50 PM
 */
@Mapper
public interface IdCardMapper {

    @Select("SELECT * FROM t_id_card WHERE id = #{0}")
    IdCard selectById(Long id);

    @Select(" SELECT id, user_id, id_no, created_time, updated_time " +
            " FROM t_id_card " +
            " WHERE id = #{0} ")
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "user",
                    column = "user_id",
                    one = @One(fetchType = FetchType.LAZY,
                               select = "com.webbdong.springboot.mybatis.mapper.UserMapper.selectById"))
    })
    IdCard selectCascadeById(Long id);

}
