package com.example.Controller;

import com.example.Entity.Account;
import com.example.Main;
import com.example.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/accounts")
public class AccountController {

    @Autowired
    public AccountService accountService;

    public Account createAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Long id){
        return accountService.getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));
    }

    @GetMapping("/{id}/deposit")
    public Account deposit(@PathVariable Long id, @RequestBody Map<String,Double> request){
        Double amount = request.get("amount");
        return accountService.deposit(id,amount);
    }

    @GetMapping("/{id}/withdraw")
    public Account withdraw(@PathVariable Long id, @RequestBody Map<String,Double> request){
        Double amount = request.get("amount");
        return accountService.withdraw(id,amount);
    }
}
