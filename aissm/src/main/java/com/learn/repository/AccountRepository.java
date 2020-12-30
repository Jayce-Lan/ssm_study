package com.learn.repository;

import com.learn.entity.Account;

import java.util.List;

public interface AccountRepository {
    List<Account> getAccountList();
}
