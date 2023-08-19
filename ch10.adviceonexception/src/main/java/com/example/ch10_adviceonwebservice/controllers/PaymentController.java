package com.example.ch10_adviceonwebservice.controllers;

import com.example.ch10_adviceonwebservice.services.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PaymentController {

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    PaymentService paymentService;

    @PostMapping("/pay")
    public ResponseEntity<?> doPayment(@RequestParam Double amount){
        paymentService.acceptPayment(amount);
        return ResponseEntity.ok().build();
    }
}
