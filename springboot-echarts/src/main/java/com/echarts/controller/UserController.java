package com.echarts.controller;

import com.echarts.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @RequestMapping("/user")
    @ResponseBody
    public List<User> getUsers() {
        List<User> list = new ArrayList<>();
        User user1 = new User("张三", 25);
        User user2 = new User("李四", 40);
        User user3 = new User("王五", 23);
        User user4 = new User("赵六", 30);
        User user5 = new User("周七", 55);

        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);

        return list;
    }
}
