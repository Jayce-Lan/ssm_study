package com.ssm.ioc_di.service;

import com.ssm.ioc_di.dao.UserDao;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void login() {
        this.userDao.login();
        System.out.println("UserService.login");
    }
}
