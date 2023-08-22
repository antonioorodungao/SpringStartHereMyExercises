package com.example.ch11_usingresttemplate.controllers;

import com.example.ch11_usingresttemplate.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RestController
public class PaymentController {


    PaymentProxy paymentProxy;

    public PaymentController(PaymentProxy paymentProxy) {
        this.paymentProxy = paymentProxy;
    }

    @PostMapping("/payment_main")
    public ResponseEntity<Payment> pay(@RequestBody Payment payment){

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(paymentProxy.callPayment(payment));

    }
}
