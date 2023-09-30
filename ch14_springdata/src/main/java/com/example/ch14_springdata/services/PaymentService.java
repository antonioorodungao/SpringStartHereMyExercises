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
        return repository.findAccountById(id).orElseThrow((AccountNotFoundException::new));
    }

    public List<Account> getAccountsByName(String name) {
        return repository.findAccountsByName(name);
    }

    @Transactional
    public boolean transfer(long sourceId, long destinationId, BigDecimal amount) throws AccountNotFoundException {
//        Account srcAcc = getAccount(sourceId);
//        Account destAcc = getAccount(destinationId);

        Account srcAcc = repository.findAccountById(sourceId).orElseThrow(AccountNotFoundException::new);
        Account destAcc = repository.findAccountById(destinationId).orElseThrow(AccountNotFoundException::new);

        boolean update = updateAccountBalance(srcAcc.getId(), srcAcc.getBalance().subtract(amount));
        update = updateAccountBalance(destinationId, destAcc.getBalance().add(amount));
        return update;

    }

    public boolean updateAccountBalance(long id, BigDecimal amount) {
        return repository.updateAccountBalance(id, amount
        );
    }
}
