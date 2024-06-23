package com.bforbank.testProject.expection;

import com.bforbank.testProject.model.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleClientNotFoundException(ClientNotFoundException ex) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), "Client not found");
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(TraderNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleTraderNotFoundException(TraderNotFoundException ex) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), "Trader not found");
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(PotNotFoundException.class)
    public ResponseEntity<ErrorDetails> handlePotNotFoundException(PotNotFoundException ex) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), "Pot not found");
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

}
