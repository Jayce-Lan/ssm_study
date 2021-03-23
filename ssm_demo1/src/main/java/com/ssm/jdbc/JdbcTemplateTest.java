package com.ssm.jdbc;

import com.ssm.jdbc.dao.UserDao;
import com.ssm.jdbc.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcTemplateTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbcxml/jdbcbean1.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
        UserDao userDao = (UserDao) context.getBean("userDao");

        findUserById(userDao);
    }

    public static void createTable(JdbcTemplate jdbcTemplate) {
        //使用execute()执行sql语句
        jdbcTemplate.execute("create table user(" +
                "id int primary key auto_increment," +
                "username varchar(40)," +
                "password varchar(40)" +
                ")");
    }

    public static void addUser(UserDao userDao) {
        User user = new User();
        user.setId(3);
        user.setUsername("Jim");
        user.setPassword("oooppp");
        int count = userDao.addUser(user);

        System.out.println(count > 0 ? "添加成功" + count + "名用户" : "添加用户失败！");
    }

    public static void updateUser(UserDao userDao) {
        User user = new User();
        user.setId(1);
        user.setUsername("Tony");
        user.setPassword("123456");

        int count = userDao.updateUser(user);
        System.out.println(count > 0 ? "修改成功" + count + "名用户信息" : "修改信息失败！");
    }

    public static void deleteUser(UserDao userDao) {
        int count = userDao.deleteUser(2);
        System.out.println(count > 0 ? "删除成功" + count + "名用户" : "删除失败！");
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
}
