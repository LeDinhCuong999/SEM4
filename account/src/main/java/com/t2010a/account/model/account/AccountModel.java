package com.t2010a.account.model.account;

import com.t2010a.account.entity.Account;

import java.util.List;

public interface AccountModel {

    Account save(Account obj); // lưu thông tin.

    List<Account> findAll();

    Account findById(int id);

    Account findByUsername(String username);

    Account findByEmail(String email);

    Account update(int id, Account updateObj);

    boolean delete(int id);
}
