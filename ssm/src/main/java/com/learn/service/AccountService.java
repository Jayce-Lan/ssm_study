package com.learn.service;

import com.learn.pojo.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAccountList();
    int saveAccount(Account account);
}
