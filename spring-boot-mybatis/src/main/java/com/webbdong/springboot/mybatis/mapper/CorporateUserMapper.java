package com.webbdong.springboot.mybatis.mapper;

import com.webbdong.springboot.mybatis.entity.discriminator.CorporateUser;
import org.apache.ibatis.annotations.Select;

/**
 * @author Webb Dong
 * @date 2021-04-23 4:01 PM
 */
public interface CorporateUserMapper {

    @Select("SELECT * FROM t_corporate_user WHERE id = #{0}")
    CorporateUser selectById(Long id);

}
