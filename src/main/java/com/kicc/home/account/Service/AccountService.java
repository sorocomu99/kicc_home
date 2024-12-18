package com.kicc.home.account.Service;

import com.kicc.home.account.vo.Account;

import java.util.List;

public interface AccountService {
    public Account getAccountById(Account account);
    public void insert(Account account);
    public void update(Account account);
    public boolean delete(String id);

    public List<Account> getList();
}
