package com.iocTest.demo1;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Person {
    @Resource(name = "bike")
    private Movable movable;

    public Person() {
        movable = new Bike();
    }

    public String go() {
        return movable.go("乘坐交通工具去上班");
    }
}
