package com.learn.test;

import com.learn.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    @Test
    public void run() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService service = context.getBean("accountService", AccountService.class);
        service.getAccountList();
    }
}
