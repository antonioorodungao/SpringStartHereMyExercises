package com.example.ch14_springdata;

import com.example.ch14_springdata.exceptions.AccountNotFoundException;
import com.example.ch14_springdata.model.Account;
import com.example.ch14_springdata.repositories.AccountRepository;
import com.example.ch14_springdata.services.PaymentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PaymentServiceUnitTests {
    @Test
    @DisplayName("Test the amount is transferred " +
            "from one account to another if no exception occurs")
    public void moneyTransferHappyFlow() {

        AccountRepository accountRepository = mock(AccountRepository.class);

        PaymentService ps = new PaymentService(accountRepository);

        Account sender = new Account();
        sender.setId(1);
        sender.setBalance(new BigDecimal(1000));

        Account destination = new Account();
        destination.setId(2);
        destination.setBalance(new BigDecimal(500));

        given(accountRepository.findAccountById(sender.getId())).willReturn(Optional.of(sender));
        given(accountRepository.findAccountById(destination.getId())).willReturn(Optional.of(destination));

        try {
            ps.transfer(sender.getId(), destination.getId(),new BigDecimal(100) );
        } catch (AccountNotFoundException e) {
            throw new RuntimeException(e);
        }


        verify(accountRepository).updateAccountBalance(1L, new BigDecimal(900));
       verify(accountRepository).updateAccountBalance(2L, new BigDecimal(600));


    }


}
