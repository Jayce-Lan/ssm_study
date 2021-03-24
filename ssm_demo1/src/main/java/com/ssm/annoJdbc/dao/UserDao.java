package com.ssm.annoJdbc.dao;

import com.ssm.annoJdbc.pojo.User;

import java.util.List;

public interface UserDao {

    public User findUserById(int id);

    public List<User> findAllUser();

    public void transfer(int outUserId, int inUserId, Integer jf);
}
