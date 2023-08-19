package com.example.ch10_restwebservices.services;

import com.example.ch10_restwebservices.exceptions.InsufficientBalanceException;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService {

    public void processPayment() throws InsufficientBalanceException{
        throw new InsufficientBalanceException();
    }
}
