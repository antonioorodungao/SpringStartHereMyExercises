package com.example.ch14_springdata.repositories;

import com.example.ch14_springdata.model.Account;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository  extends CrudRepository<Account, Long> {

    Optional<Account> findAccountById(long id);
    List<Account> findAll();

    List<Account> findAccountsByName(String name);



    @Modifying
    @Query("Update ACCOUNT set Balance=:amount where id=:id")
    boolean updateAccountBalance(long id, BigDecimal amount);

}
