package com.ssm.aspectj;

import com.ssm.aspectj.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    private static ApplicationContext context;

    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext("aspect.xml");
        addUser(context);
    }

    public static void addUser(ApplicationContext context) {
        UserDao userDao = (UserDao) context.getBean("userDao");
        userDao.addUser();
    }

    public static void delete(ApplicationContext context) {
        UserDao userDao = (UserDao) context.getBean("userDao");
        userDao.deleteUser();
    }
}
