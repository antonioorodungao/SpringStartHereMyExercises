package com.example.ch11_openfeign.proxy;

import com.example.ch11_openfeign.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

//Note: The OpenFeign client will call another endpoing using url and mapping annotation.
@FeignClient(name ="payments", url="${name.service.url}")
public interface OpenFeignProxy {

    @PostMapping("/payment")
    Payment createPayment(@RequestHeader String requestId, @RequestBody Payment payment);
}
