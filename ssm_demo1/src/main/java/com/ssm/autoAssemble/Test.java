package com.ssm.autoAssemble;

import com.ssm.autoAssemble.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    private static ApplicationContext context;

    public static void main(String[] args) {
        String xmlPath = "autoAssemble.xml";
        context = new ClassPathXmlApplicationContext(xmlPath);

        UserController userController = (UserController) context.getBean("userController");

        userController.save();
    }
}
