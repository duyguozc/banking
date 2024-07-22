package com.example.banking;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Transaction {

    @Id
    @GeneratedValue
    private Long transactionID;
    private String transactionType;
    private double amount;
    private String date;
    private String time;
    private String description;

    @ManyToOne
    private Account account;

    // Default constructor
    public Transaction() {
    }

    // Parameterized constructor
    public Transaction(String transactionType, double amount, String date, String time, String description, Account account) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.date = date;
        this.time = time;
        this.description = description;
        this.account = account;
    }

    // Getters and Setters
    public Long getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Long transactionID) {
        this.transactionID = transactionID;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    // Overriding equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(that.amount, amount) == 0 &&
                Objects.equals(transactionID, that.transactionID) &&
                Objects.equals(transactionType, that.transactionType) &&
                Objects.equals(date, that.date) &&
                Objects.equals(time, that.time) &&
                Objects.equals(description, that.description) &&
                Objects.equals(account, that.account);
    }

    // Overriding hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(transactionID, transactionType, amount, date, time, description, account);
    }

    // Overriding toString method
    @Override
    public String toString() {
        return "Transaction{" +
                "transactionID=" + transactionID +
                ", transactionType='" + transactionType + '\'' +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", description='" + description + '\'' +
                ", account=" + account +
                '}';
    }
}
