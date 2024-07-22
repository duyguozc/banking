package com.example.banking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findByInterestRate(double rate);

    List<Account> findByMemberName(String memberName);

    @Query("SELECT a FROM Account a WHERE a.member.name = :name AND a.balance > :balance")
    List<Account> findAccountsByThreshold(@Param("name") String name, @Param("balance") Double balance);

}
