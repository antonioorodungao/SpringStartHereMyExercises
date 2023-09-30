package com.example.ch14_springdata.controllers;

import com.example.ch14_springdata.exceptions.AccountNotFoundException;
import com.example.ch14_springdata.model.Account;
import com.example.ch14_springdata.model.TransferRequest;
import com.example.ch14_springdata.services.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class PaymentsController {

    PaymentService service;

    public PaymentsController(PaymentService service) {
        this.service = service;
    }

    @PostMapping("/transfer")
    public ResponseEntity transfer(@RequestBody  TransferRequest request) throws AccountNotFoundException {
        boolean success = service.transfer(request.getSourceAccountId(), request.getDestinationAccountId(), request.getAmount());
        return ResponseEntity.accepted().body(success);
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAccounts(){
        return ResponseEntity.ok(service.getAccounts());
    }

    @GetMapping("/account")
    public ResponseEntity<Account> getAccountbyId(@RequestParam long id ) throws AccountNotFoundException {
        return ResponseEntity.ok(service.getAccount(id));
    }

    @GetMapping("/account/name")
    public ResponseEntity<List<Account>> getAccountsByName(@RequestParam String name){
        return ResponseEntity.ok(service.getAccountsByName(name));
    }

    @PostMapping("/updatebalance")
    public ResponseEntity updateBalance(@RequestParam long id, @RequestParam BigDecimal amount){
        boolean success = service.updateAccountBalance(id, amount);
        return  ResponseEntity.accepted().body(success);
    }
}
