package com.example.lab11;

public class CustomNotFoundException extends RuntimeException{

    public CustomNotFoundException(String msg) {
        super(msg);
    }
}