package com.learn.test;

import com.learn.entity.Account;
import com.learn.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void testMysql() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        AccountService service = context.getBean("accountService", AccountService.class);
        for (Account account : service.getAccountList()) {
            System.out.println(account);
        }
    }
}
