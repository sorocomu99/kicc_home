package com.kicc.home.dao.account;

import com.kicc.home.account.vo.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountDAO {
    Account findById(Account account);

    void insertAccount(Account account);

    void updateAccount(Account account);

    int deleteAccount(String id);

    void updateLogin(String id, boolean success);

    List<Account> selectList();
}

