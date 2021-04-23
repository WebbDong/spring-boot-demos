package com.webbdong.springboot.mybatis.mapper;

import com.webbdong.springboot.mybatis.entity.discriminator.PersonalUser;
import org.apache.ibatis.annotations.Select;

/**
 * @author Webb Dong
 * @date 2021-04-23 4:02 PM
 */
public interface PersonalUserMapper {

    @Select("SELECT * FROM t_personal_user WHERE id = #{0}")
    PersonalUser selectById(Long id);

}
