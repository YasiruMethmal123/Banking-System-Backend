package com.example.Service;

import com.example.Entity.Account;
import com.example.Repository.AccountRepository;
import java.util.Optional;

public class AccountService {
    private AccountRepository accountRepository;

    public Account createAccount(Account account){
        return accountRepository.save(account);
    }

    public Optional<Account> getAccount(Long id){
        return accountRepository.findById(id);
    }

    public Account deposit(Long id , double amount){
        Account account = getAccount(id).orElseThrow(() -> new RuntimeException("Account not found !"));
        account.setBalance(account.getBalance()+amount);
        return accountRepository.save(account);
    }

    public Account withdraw(Long id,double amount){
        Account account = getAccount(id).orElseThrow(() -> new RuntimeException("Account not found !"));
        if (account.getBalance() < amount){
            throw new RuntimeException("Insufficient funds");
        }
        account.setBalance(account.getBalance() - amount);
        return accountRepository.save(account);
    }
}
