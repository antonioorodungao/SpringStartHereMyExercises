package com.example.ch11_restproxywebflux.controllers;

import com.example.ch11_restproxywebflux.model.Payment;
import com.example.ch11_restproxywebflux.proxies.PaymentProxy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class PaymentsController {

    private final PaymentProxy webfluxProxy;

    public PaymentsController(PaymentProxy webfluxProxy) {
        this.webfluxProxy = webfluxProxy;
    }

    @PostMapping("/payment")
    public Mono<Payment> payment(@RequestBody Payment payment){
        String requestId = java.util.UUID.randomUUID().toString();
        Mono<Payment> mono = webfluxProxy.createPayment(requestId, payment);
        return mono;


    }
}
