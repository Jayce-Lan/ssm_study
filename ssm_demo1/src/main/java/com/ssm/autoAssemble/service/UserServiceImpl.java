package com.ssm.autoAssemble.service;

import com.ssm.autoAssemble.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        this.userDao.save();
        System.out.println("UserService save");
    }
}
