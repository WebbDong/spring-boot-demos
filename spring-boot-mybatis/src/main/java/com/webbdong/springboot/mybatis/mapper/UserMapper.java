package com.webbdong.springboot.mybatis.mapper;

import com.webbdong.springboot.mybatis.entity.onetoone.User;
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
public interface UserMapper {

    @Select("SELECT * FROM t_user WHERE id = #{0}")
    User selectById(Long id);

    @Select("SELECT * FROM t_user WHERE id = #{0}")
    @Results({
            @Result(property = "idcardId", column = "idcard_id"),
            @Result(property = "idCard",
                    column = "idcard_id",
                    one = @One(fetchType = FetchType.LAZY,
                               select = "com.webbdong.springboot.mybatis.mapper.IdCardMapper.selectById"))
    })
    User selectCascadeById(Long id);

}
