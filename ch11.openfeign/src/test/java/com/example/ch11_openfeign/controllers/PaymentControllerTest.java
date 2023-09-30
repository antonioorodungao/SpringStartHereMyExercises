package com.example.ch11_openfeign.controllers;

import com.example.ch11_openfeign.model.Payment;
import com.example.ch11_openfeign.proxy.OpenFeignProxy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PaymentControllerTest {

    @Mock
    OpenFeignProxy paymentProxy;

    @InjectMocks
    PaymentController paymentController;

    @Test
    void createPayment() {
        Payment p = new Payment();
        p.setAmount(new BigDecimal(100));
        p.setId("1");


        given(paymentProxy.createPayment(p.getId(), p)).willReturn(p);
        paymentController.createPayment(p);
        verify(paymentProxy).createPayment(any(), any());

    }
}