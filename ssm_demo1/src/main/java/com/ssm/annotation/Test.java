package com.ssm.annotation;

import com.ssm.annotation.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    private static ApplicationContext context;

    public static void main(String[] args) {
        String xmlPath = "bean1.xml";
        context = new ClassPathXmlApplicationContext(xmlPath);

        UserController userController = (UserController) context.getBean("userController");

        userController.save();
    }
}
