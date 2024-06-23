package com.bforbank.testProject.expection;

public class PotNotFoundException extends RuntimeException{
    public PotNotFoundException(String message) {
        super(message);
    }
}
