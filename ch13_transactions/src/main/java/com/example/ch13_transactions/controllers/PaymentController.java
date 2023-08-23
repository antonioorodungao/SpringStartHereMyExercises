package com.example.ch13_transactions.controllers;

import com.example.ch13_transactions.model.Account;
import com.example.ch13_transactions.model.TransferRequest;
import com.example.ch13_transactions.repositories.AccountRepository;
import com.example.ch13_transactions.service.TransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class PaymentController {

    TransferService transferService;

    public PaymentController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public ResponseEntity<TransferRequest> transfer(@RequestBody TransferRequest request){
        transferService.transfer(request);
            return ResponseEntity.ok(request);
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAccounts(){

        return ResponseEntity.ok().body(transferService.getAllAccounts());

    }
}
