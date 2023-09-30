package com.example.ch14_springdata;


import com.example.ch14_springdata.exceptions.AccountNotFoundException;
import com.example.ch14_springdata.model.Account;
import com.example.ch14_springdata.repositories.AccountRepository;
import com.example.ch14_springdata.services.PaymentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceUnitTestAnnotation {
    @Mock
    AccountRepository accountRepository;

    @InjectMocks
    PaymentService paymentService;

    @Test
    @DisplayName("Test the exception thrown by transfer method")
    public void moneyTransferException(){

        Account sender = new Account();
        sender.setBalance(new BigDecimal(1000));
        sender.setId(1);

        Account receiver = new Account();
        receiver.setBalance(new BigDecimal(1000));

        given(accountRepository.findAccountById(sender.getId())).willReturn(Optional.of(sender));
        given(accountRepository.findAccountById(2L)).willReturn(Optional.empty());

        assertThrows(AccountNotFoundException.class, () -> paymentService.transfer(1,2,new BigDecimal(100)));

        verify(accountRepository, never()).updateAccountBalance(anyLong(), any());


    }
}
