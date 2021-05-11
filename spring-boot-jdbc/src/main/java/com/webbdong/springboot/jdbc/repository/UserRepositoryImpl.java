package com.webbdong.springboot.jdbc.repository;

import com.webbdong.springboot.jdbc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Webb Dong
 * @date 2021-05-11 10:59 PM
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM `user`", new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public User findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM `user` WHERE `id` = ?",
                new BeanPropertyRowMapper<>(User.class), id);
    }

    @Override
    public int update(User user) {
        return jdbcTemplate.update("UPDATE `user` SET `user_name` = ?, `password` = ? WHERE `id` = ?",
                user.getUserName(), user.getPassword(), user.getId());
    }

    @Override
    public int save(User user) {
        String sql = "INSERT INTO `user`(`user_name`, `password`, `last_login_time`, `gender`) " +
                "VALUES(?, ?, ?, ?)";
        return jdbcTemplate.update(sql, user.getUserName(), user.getPassword(),
                user.getLastLoginTime(), user.getGender());
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM `user` WHERE `id` = ?", id);
    }

}
