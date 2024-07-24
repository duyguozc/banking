package com.example.banking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private MemberService memberService;

    @GetMapping("/{memberName}")
    public List<Account> getAccountsOfMember(@PathVariable String memberName){
        return accountService.getAccountsByMemberName(memberName);
    }

    List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @PostMapping("/add")
    public ResponseEntity<?> newAccount(@RequestBody Account newAccount, @RequestParam Long memberId) {
        Member member = memberService.getMemberById(memberId);
        if (member != null) {
            newAccount.setMember(member);
            Account savedAccount = accountService.addNewAccount(newAccount);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedAccount);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Member not found with ID: " + memberId);
        }
    }

    @GetMapping("/member")
    public ResponseEntity<List<Account>> findAccountsByThreshold(
            @RequestParam String name,
            @RequestParam Double balance) {
        List<Account> accounts = accountService.findAccountsByThreshold(name, balance);
        return ResponseEntity.ok(accounts);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable Long id){
        if(accountService.accountExists(id)){
            accountService.deleteAccount(id);
            return ResponseEntity.ok("Account deleted successfully.");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Account not found with ID: " + id);
        }

    }


}
