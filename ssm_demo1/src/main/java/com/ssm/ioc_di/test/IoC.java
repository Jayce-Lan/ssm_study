package com.ssm.ioc_di.test;

import com.ssm.ioc_di.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IoC {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao userDao = (UserDao) context.getBean("UserDao");

        userDao.login();
    }
}
