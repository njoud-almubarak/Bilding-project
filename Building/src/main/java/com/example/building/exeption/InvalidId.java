package com.example.building.exeption;

public class InvalidId extends RuntimeException{

    public InvalidId(String message) {
        super(message);
    }
}
