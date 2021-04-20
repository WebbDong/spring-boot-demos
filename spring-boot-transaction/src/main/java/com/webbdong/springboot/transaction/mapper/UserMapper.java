package com.webbdong.springboot.transaction.mapper;

import com.webbdong.springboot.transaction.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> selectAll();

    User selectById(@Param("id") long id);

    int updateUserNameById(@Param("userName") String userName, @Param("id") long id);

    void save(@Param("user") User user);

}
