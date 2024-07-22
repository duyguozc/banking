package com.example.banking;

public class MemberNotFoundException extends RuntimeException{

    MemberNotFoundException(Long id) {
        super("Could not find member " + id);
    }
}
