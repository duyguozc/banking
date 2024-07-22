package com.example.banking;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class

Account {

    @Id
    @GeneratedValue
    private Long accountID;
    private String accountType;
    private double balance;
    private double interestRate;
    private String dateOpened;

    @ManyToOne
    private Member member;

    // Default constructor
    public Account() {
    }

    // Parameterized constructor
    public Account(String accountType, double balance, double interestRate, String dateOpened, Member member) {
        this.accountType = accountType;
        this.balance = balance;
        this.interestRate = interestRate;
        this.dateOpened = dateOpened;
        this.member = member;
    }

    // Getters and Setters
    public Long getAccountID() {
        return accountID;
    }

    public void setAccountID(Long accountID) {
        this.accountID = accountID;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public String getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(String dateOpened) {
        this.dateOpened = dateOpened;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    // Overriding equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(account.balance, balance) == 0 &&
                Double.compare(account.interestRate, interestRate) == 0 &&
                Objects.equals(accountID, account.accountID) &&
                Objects.equals(accountType, account.accountType) &&
                Objects.equals(dateOpened, account.dateOpened) &&
                Objects.equals(member, account.member);
    }

    // Overriding hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(accountID, accountType, balance, interestRate, dateOpened, member);
    }

    // Overriding toString method
    @Override
    public String toString() {
        return "Account{" +
                "accountID=" + accountID +
                ", accountType='" + accountType + '\'' +
                ", balance=" + balance +
                ", interestRate=" + interestRate +
                ", dateOpened='" + dateOpened + '\'' +
                ", member=" + member +
                '}';
    }
}
