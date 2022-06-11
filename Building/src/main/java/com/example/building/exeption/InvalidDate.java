package com.example.building.exeption;

public class InvalidDate extends RuntimeException{
    public InvalidDate(String message) {
        super(message);
    }
}
