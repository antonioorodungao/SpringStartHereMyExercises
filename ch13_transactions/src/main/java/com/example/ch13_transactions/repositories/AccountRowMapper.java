package com.example.ch13_transactions.repositories;

import com.example.ch13_transactions.model.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {

    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account acc = new Account();
        acc.setId(rs.getInt("id"));
        acc.setName(rs.getString("name"));
        acc.setBalance(rs.getBigDecimal("balance"));
        return acc;
    }
}
