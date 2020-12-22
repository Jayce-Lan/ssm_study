package com.learn.dao;

import com.learn.pojo.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDao {
    @Select("select * from account")
    List<Account> getAccountList();

    @Insert("insert into account (name, money) values (#{name}, #{money})")
    int saveAccount(Account account);
}
