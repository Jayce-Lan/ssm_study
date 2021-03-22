package com.ssm.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        singleton();
    }

    /**
     * 测试是否为单例对象
     */
    public static void singleton() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Scope scope1 = (Scope) context.getBean("Scope");
        Scope scope2 = (Scope) context.getBean("Scope");

        System.out.println(scope1);
        System.out.println(scope2);
        System.out.println(scope1 == scope2);
    }
}
