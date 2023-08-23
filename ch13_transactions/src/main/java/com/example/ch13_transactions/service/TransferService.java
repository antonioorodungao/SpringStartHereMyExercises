package com.example.ch13_transactions.service;

import com.example.ch13_transactions.model.Account;
import com.example.ch13_transactions.model.TransferRequest;
import com.example.ch13_transactions.repositories.AccountRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {
    AccountRepository accountRepository;

    public TransferService(AccountRepository repository) {
        this.accountRepository = repository;
    }

    @Transactional
    public void transfer(TransferRequest transferRequest) {

        Account sourceAccount = accountRepository.findById(transferRequest.getSourceAccountId());
        Account destinationAccount = accountRepository.findById(transferRequest.getDestinationAccountId());
        BigDecimal sourceAccountBalance = sourceAccount.getBalance();
        BigDecimal destinationAccountBalance = destinationAccount.getBalance();

        accountRepository.changeAmount(transferRequest.getSourceAccountId(), sourceAccountBalance.subtract(transferRequest.getAmount()));
        accountRepository.changeAmount(transferRequest.getDestinationAccountId(), destinationAccountBalance.add(transferRequest.getAmount()));
        throw new RuntimeException("Update Balance Exception");
    }

    public List<Account> getAllAccounts() {
        return accountRepository.getAllAccounts();
    }
}
