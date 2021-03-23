package com.ssm.annotation.controller;

import com.ssm.annotation.service.UserService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller("userController")
public class UserController {
    @Resource(name = "userService")
    private UserService userService;

    public void save() {
        this.userService.save();
        System.out.println("UserController save");
    }
}
