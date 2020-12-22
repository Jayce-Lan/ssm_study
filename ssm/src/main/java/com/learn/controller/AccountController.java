package com.learn.controller;

import com.learn.pojo.Account;
import com.learn.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//账户web
@Controller
@RequestMapping("account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("testGetAccountList")
    public String getAccountList(Model model) {
        System.out.println("表现层查询所有账户信息...");

        //调用service的方法
        List<Account> accountList = accountService.getAccountList();
        model.addAttribute("accountList", accountList);

        return "list";
    }

    @RequestMapping("testSaveAccount")
    public void saveAccount(Account account, HttpServletResponse response, HttpServletRequest request) throws IOException {
        System.out.println("表现层保存用户...");

        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath() + "/account/testGetAccountList");    //重定向

        return;
    }
}
