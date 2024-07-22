package com.example.banking;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    public List<Account> getAccountsByMemberName(String name) {
        List<Account> accountList = repository.findByMemberName(name);
        return accountList;
    }

    public List<Account> getAllAccounts(){
        return repository.findAll();
    }

    Account addNewAccount(Account account){
        return repository.save(account);
    }

    List<Account> findAccountsByThreshold(String name, Double balance){
        return repository.findAccountsByThreshold(name, balance);
    }


}
