package com.learn.service.impl;

import com.learn.entity.Account;
import com.learn.repository.AccountRepository;
import com.learn.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> getAccountList() {
        return accountRepository.getAccountList();
    }
}
