package com.bforbank.testProject.expection;

public class TraderNotFoundException extends RuntimeException{
    public TraderNotFoundException(String message) {
        super(message);
    }
}
