package com.example.ch11_openfeign.controllers;

import com.example.ch11_openfeign.model.Payment;
import com.example.ch11_openfeign.proxy.OpenFeignProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    OpenFeignProxy paymentProxy;

    public PaymentController(OpenFeignProxy paymentProxy) {
        this.paymentProxy = paymentProxy;
    }

    @PostMapping("/payment_main")
    public Payment createPayment(@RequestBody Payment payment) {
        String requestId = java.util.UUID.randomUUID().toString();
        return paymentProxy.createPayment(requestId, payment);
    }
}
