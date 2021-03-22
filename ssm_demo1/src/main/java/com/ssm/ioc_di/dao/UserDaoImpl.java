package com.ssm.ioc_di.dao;

public class UserDaoImpl implements UserDao {
    @Override
    public void login() {
        System.out.println("UserDao.login");
    }
}
