package com.ssm.annoJdbc.dao;

import com.ssm.annoJdbc.pojo.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
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

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    @Override
    public void transfer(int outUserId, int inUserId, Integer jf) {

        this.jdbcTemplate.update("update user set jf = jf-? where id = ?", jf, outUserId);

        //模拟异常
        int i = 1 / 0;

        this.jdbcTemplate.update("update user set jf = jf+? where id = ?", jf, inUserId);

        System.out.println("积分赠送成功！");
    }
}
