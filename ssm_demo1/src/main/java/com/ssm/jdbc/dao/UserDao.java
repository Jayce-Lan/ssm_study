package com.ssm.jdbc.dao;

import com.ssm.jdbc.pojo.User;

import java.util.List;

public interface UserDao {
    public int addUser(User user);

    public int updateUser(User user);

    public int deleteUser(int id);

    public User findUserById(int id);

    public List<User> findAllUser();

    public void transfer(int outUserId, int inUserId, Integer jf);
}
