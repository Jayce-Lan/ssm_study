package com.ssm.annoJdbc;

import com.ssm.annoJdbc.dao.UserDao;
import com.ssm.annoJdbc.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcTemplateTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbcxml/jdbcbean2.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");

        findAllUser(userDao);
        System.out.println("=========================================");
        transfer(userDao);
        System.out.println("=========================================");
        findAllUser(userDao);
    }


    public static void findUserById(UserDao userDao) {
        User user = userDao.findUserById(4);
        System.out.println(user != null ? user : "无此用户");
    }

    public static void findAllUser(UserDao userDao) {
        List<User> userList = userDao.findAllUser();

        for (User user : userList) {
            System.out.println(user);
        }
    }

    public static void transfer(UserDao userDao) {
        userDao.transfer(4, 5, 100);
    }
}
