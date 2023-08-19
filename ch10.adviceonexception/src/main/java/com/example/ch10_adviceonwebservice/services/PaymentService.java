package com.example.ch10_adviceonwebservice.services;

import com.example.ch10_adviceonwebservice.exceptions.InsufficientFundsException;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public void acceptPayment(Double amount){


        try {
            throw new InsufficientFundsException();
        } catch (InsufficientFundsException e) {
            throw new RuntimeException(e);
        }
    }

}
