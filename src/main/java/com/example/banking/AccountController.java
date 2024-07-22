package com.example.banking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/{memberName}")
    public List<Account> getAccountsOfMember(@PathVariable String memberName){
        return accountService.getAccountsByMemberName(memberName);
    }

    List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @PostMapping("/")
    Account newAccount(@RequestBody Account newAccount){
        return accountService.addNewAccount(newAccount);
    }

    @GetMapping("/member")
    public ResponseEntity<List<Account>> findAccountsByThreshold(
            @RequestParam String name,
            @RequestParam Double balance) {
        List<Account> accounts = accountService.findAccountsByThreshold(name, balance);
        return ResponseEntity.ok(accounts);
    }


}
