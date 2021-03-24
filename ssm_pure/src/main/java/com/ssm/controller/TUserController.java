package com.ssm.controller;

import com.ssm.entity.TUser;
import com.ssm.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TUserController {
    @Autowired
    private TUserService tUserService;

    @RequestMapping("/finduserbyid")
    public String findUserById(Integer id, Model model) {
        TUser user = tUserService.findUserById(id);
        model.addAttribute("user", user);

        return "user";
    }
}
