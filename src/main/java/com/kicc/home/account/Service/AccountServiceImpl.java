package com.kicc.home.account.Service;

import com.kicc.home.dao.account.AccountDAO;
import com.kicc.home.account.vo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Account getAccountById(Account account) {
        return accountDAO.findById(account);
    }

    @Override
    public void insert(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        accountDAO.insertAccount(account);
    }

    @Override
    public void update(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        accountDAO.updateAccount(account);
    }

    @Override
    public boolean delete(String id) {
        return accountDAO.deleteAccount(id) > 0;
    }

    @Override
    public List<Account> getList() {
        return accountDAO.selectList();
    }
}
