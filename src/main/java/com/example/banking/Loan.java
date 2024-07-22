package com.example.banking;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Loan {

    @Id
    @GeneratedValue
    private Long loanID;
    private double principalAmount;
    private double interestRate;
    private int term;
    private String startDate;
    private String endDate;
    private String status;

    @ManyToOne
    private Member member;

    // Default constructor
    public Loan() {
    }

    // Parameterized constructor
    public Loan(double principalAmount, double interestRate, int term, String startDate, String endDate, String status, Member member) {
        this.principalAmount = principalAmount;
        this.interestRate = interestRate;
        this.term = term;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.member = member;
    }

    // Getters and Setters
    public Long getLoanID() {
        return loanID;
    }

    public void setLoanID(Long loanID) {
        this.loanID = loanID;
    }

    public double getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(double principalAmount) {
        this.principalAmount = principalAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        Loan loan = (Loan) o;
        return Double.compare(loan.principalAmount, principalAmount) == 0 &&
                Double.compare(loan.interestRate, interestRate) == 0 &&
                term == loan.term &&
                Objects.equals(loanID, loan.loanID) &&
                Objects.equals(startDate, loan.startDate) &&
                Objects.equals(endDate, loan.endDate) &&
                Objects.equals(status, loan.status) &&
                Objects.equals(member, loan.member);
    }

    // Overriding hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(loanID, principalAmount, interestRate, term, startDate, endDate, status, member);
    }

    // Overriding toString method
    @Override
    public String toString() {
        return "Loan{" +
                "loanID=" + loanID +
                ", principalAmount=" + principalAmount +
                ", interestRate=" + interestRate +
                ", term=" + term +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", status='" + status + '\'' +
                ", member=" + member +
                '}';
    }
}
