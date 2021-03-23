package com.ssm.autoAssemble.controller;

import com.ssm.autoAssemble.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 需要setter方法才能完成依赖注入
     * @param userService
     */
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void save() {
        this.userService.save();
        System.out.println("UserController save");
    }
}
