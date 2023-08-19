package com.example.ch10_adviceonwebservice.advices;

import com.example.ch10_adviceonwebservice.exceptions.InsufficientFundsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PaymentExceptionHandlers {

    //TODO: Is it possible to route the logs another application using another advise?
    @ExceptionHandler(InsufficientFundsException.class)
    public ResponseEntity<ErrorDetails> exceptionInsufficientFundsHandler(InsufficientFundsException e){
        ErrorDetails errorDetails = new ErrorDetails("101", "Insufficient funds");
        return ResponseEntity.badRequest().body(errorDetails);
    }
}
