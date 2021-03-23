package com.ssm.jdbc.dao;

import com.ssm.jdbc.pojo.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addUser(User user) {
        String sql = "insert into user(username, password) value(?, ?)";
        Object[] objs = {user.getUsername(), user.getPassword()};
        int count = this.jdbcTemplate.update(sql, objs);
        return count;
    }

    @Override
    public int updateUser(User user) {
        String sql = "update user set username = ?, password = ? where id = ?";
        Object[] objs = {user.getUsername(), user.getPassword(), user.getId()};
        int count = this.jdbcTemplate.update(sql, objs);
        return count;
    }

    @Override
    public int deleteUser(int id) {
        String sql = "delete from user where id = ?";
        int count = this.jdbcTemplate.update(sql, id);
        return count;
    }

    @Override
    public User findUserById(int id) {
        String sql = "select * from user where id = ?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        User user = this.jdbcTemplate.queryForObject(sql, rowMapper, id);
        return user;
    }

    @Override
    public List<User> findAllUser() {
        String sql = "select * from user";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        List<User> userList = this.jdbcTemplate.query(sql, rowMapper);
        return userList;
    }
}
