package com.example.ch14_springdata.services;

import com.example.ch14_springdata.exceptions.AccountNotFoundException;
import com.example.ch14_springdata.model.Account;
import com.example.ch14_springdata.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PaymentService {

    AccountRepository repository;

    public PaymentService(AccountRepository repository) {
        this.repository = repository;
    }

    public List<Account> getAccounts() {
        return repository.findAll();
    }

    public Account getAccount(long id) throws AccountNotFoundException {
        return repository.findAccountById(id).orElseThrow(() -> new AccountNotFoundException());
    }

    public List<Account> getAccountsByName(String name) {
        return repository.findAccountsByName(name);
    }

    @Transactional
    public boolean transfer(long sourceId, long destinationId, BigDecimal amount) throws AccountNotFoundException {
        Account srcAcc = getAccount(sourceId);
        Account destAcc = getAccount(destinationId);
        return
                updateAccountBalance(srcAcc.getBalance().subtract(amount), srcAcc.getId())
                        &&
                        updateAccountBalance(destAcc.getBalance().add(amount), destinationId);

    }

    public boolean updateAccountBalance(BigDecimal amount, long id) {
        return repository.updateAccountBalance(id, amount
        );
    }
}
