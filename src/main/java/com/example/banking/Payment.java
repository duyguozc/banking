package com.example.banking;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Payment {

    @Id
    @GeneratedValue
    private Long paymentID;
    private double paymentAmount;
    private String paymentDate;

    @ManyToOne
    private Loan loan;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Account account;

    // Default constructor
    public Payment() {
    }

    // Parameterized constructor
    public Payment(double paymentAmount, String paymentDate, Loan loan, Member member, Account account) {
        this.paymentAmount = paymentAmount;
        this.paymentDate = paymentDate;
        this.loan = loan;
        this.member = member;
        this.account = account;
    }

    // Getters and Setters
    public Long getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(Long paymentID) {
        this.paymentID = paymentID;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
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
        Payment payment = (Payment) o;
        return Double.compare(payment.paymentAmount, paymentAmount) == 0 &&
                Objects.equals(paymentID, payment.paymentID) &&
                Objects.equals(paymentDate, payment.paymentDate) &&
                Objects.equals(loan, payment.loan) &&
                Objects.equals(member, payment.member) &&
                Objects.equals(account, payment.account);
    }

    // Overriding hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(paymentID, paymentAmount, paymentDate, loan, member, account);
    }

    // Overriding toString method
    @Override
    public String toString() {
        return "Payment{" +
                "paymentID=" + paymentID +
                ", paymentAmount=" + paymentAmount +
                ", paymentDate='" + paymentDate + '\'' +
                ", loan=" + loan +
                ", member=" + member +
                ", account=" + account +
                '}';
    }
}
