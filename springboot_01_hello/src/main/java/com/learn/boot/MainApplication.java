package com.learn.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//主程序类
@SpringBootApplication      //告知springboot，这是一个springboot应用
public class MainApplication {
    public static void main(String[] args) {
        //返回ioc容器
        ConfigurableApplicationContext context = SpringApplication.run(MainApplication.class, args);    //运行主程序应用(固定写法)
        //查看容器组件
        String[] names = context.getBeanDefinitionNames();

        for (String name : names) {
            System.out.println(name);
        }
    }
}
