package com.ssm.assemble;

import com.ssm.assemble.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        testBean1();
    }

    /**
     * 测试bean实例创建的方法
     */
    public static void testBean1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        User user1 = (User) context.getBean("user1");
        User user2 = (User) context.getBean("user2");

        System.out.println(user1.toString());
        System.out.println(user2.toString());
    }
}
