package com.learn.service.impl;

import com.learn.dao.AccountDao;
import com.learn.pojo.Account;
import com.learn.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> getAccountList() {
        System.out.println("业务层查询账户表单...");
        return accountDao.getAccountList();
    }

    @Override
    public int saveAccount(Account account) {
        System.out.println("业务层保存账户...");
        return accountDao.saveAccount(account);
    }
}
