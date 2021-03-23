package com.ssm.annotation.service;

import com.ssm.annotation.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource(name = "userDao") //使用Resource注入
    private UserDao userDao;

    @Override
    public void save() {
        this.userDao.save();
        System.out.println("UserService save");
    }
}
