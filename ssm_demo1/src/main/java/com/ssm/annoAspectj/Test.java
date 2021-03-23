package com.ssm.annoAspectj;

import com.ssm.annoAspectj.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    private static ApplicationContext context;

    public static void main(String[] args) {
        String xmlPath = "annoAspectj.xml";
        context = new ClassPathXmlApplicationContext(xmlPath);
        addUser(context);
    }

    public static void addUser(ApplicationContext context) {
        UserDao userDao = (UserDao) context.getBean("UserDao");
        userDao.addUser();
    }
}
