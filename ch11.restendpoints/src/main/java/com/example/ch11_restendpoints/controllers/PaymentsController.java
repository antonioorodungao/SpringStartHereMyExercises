package com.example.ch11_restendpoints.controllers;

import com.example.ch11_restendpoints.model.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentsController {

    private static final Logger logger = LoggerFactory.getLogger(PaymentsController.class);
    @PostMapping("/payment")
    public ResponseEntity<?> payment(@RequestHeader String requestId, @RequestBody Payment payment){
        logger.info(String.format("Received request with ID %s;\n Payment amount: %f \n", requestId, payment.getAmount()));
        payment.setId(requestId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(payment);
    }


}
