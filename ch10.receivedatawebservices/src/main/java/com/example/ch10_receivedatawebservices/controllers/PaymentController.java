package com.example.ch10_receivedatawebservices.controllers;

import com.example.ch10_receivedatawebservices.models.PaymentDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

//Note: @RestController annotation indicates that the controller handles HTTP requests and produces
// HTTP response body

@RestController
public class PaymentController {


    //Note: @RequestBody automatically maps the object to the requestBody.
    @PostMapping("/payment")
    public ResponseEntity<PaymentDetails> pay(@RequestBody PaymentDetails paymentDetails, @RequestHeader("user-agent") String useragent){

        paymentDetails.setMessage("Payment is accepted");
        System.out.println(useragent);
        paymentDetails.setTransactionID(java.util.UUID.randomUUID().toString());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(paymentDetails);
    }


}
