package com.example.banking;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class Member {

    private @Id @GeneratedValue Long memberID;
    private String name;
    private String phone;


    // Default constructor
    public Member() {
    }

    // Parameterized constructor
    public Member(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    // Getter for memberID
    public Long getMemberID() {
        return memberID;
    }

    // Setter for memberID
    public void setMemberID(Long memberID) {
        this.memberID = memberID;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for phone
    public String getPhone() {
        return phone;
    }

    // Setter for phone
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Overriding equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(memberID, member.memberID) &&
                Objects.equals(name, member.name) &&
                Objects.equals(phone, member.phone);
    }

    // Overriding hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(memberID, name, phone);
    }

    // Overriding toString method
    @Override
    public String toString() {
        return "Member{" +
                "memberID=" + memberID +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }



}
