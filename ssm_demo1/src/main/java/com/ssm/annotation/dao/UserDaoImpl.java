package com.ssm.annotation.dao;

import org.springframework.stereotype.Repository;

//dao层的注解，用于识别UserDaoImpl
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("UserDao save");
    }
}
