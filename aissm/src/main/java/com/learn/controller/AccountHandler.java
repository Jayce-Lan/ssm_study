package com.learn.controller;

import com.learn.entity.Account;
import com.learn.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("account")
public class AccountHandler {
    @Autowired
    private AccountService accountService;

    @RequestMapping("findall")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("list", accountService.getAccountList());

        System.out.println("web实现=========================");
        List<Account> accountList = accountService.getAccountList();

        for (Account account : accountList) {
            System.out.println(account);
        }

        return modelAndView;
    }
}
