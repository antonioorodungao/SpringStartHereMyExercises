package com.example.ch11_usingresttemplate.controllers;

import com.example.ch11_usingresttemplate.model.Payment;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
public class PaymentProxy {

    @Value(value = "${name.service.uri}")
    String wsURI;

    private final RestTemplate restTemplate;

    public PaymentProxy(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Payment callPayment(Payment payment){
        String uri = wsURI + "/payment";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("requestId", UUID.randomUUID().toString());
        HttpEntity<Payment> httpEntity = new HttpEntity<>(payment, httpHeaders);

        ResponseEntity<Payment> response = restTemplate.exchange(uri, HttpMethod.POST,httpEntity, Payment.class );
        return response.getBody();
    }
}
