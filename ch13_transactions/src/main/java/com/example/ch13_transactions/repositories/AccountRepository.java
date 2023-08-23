package com.example.ch13_transactions.repositories;


import com.example.ch13_transactions.model.Account;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Repository
public class AccountRepository {

    NamedParameterJdbcTemplate jdbcTemplate;
    AccountRowMapper accountRowMapper = new AccountRowMapper();

    public AccountRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Account findById(long id) {
        String sql = "SELECT * from ACCOUNT where id = :id";
        SqlParameterSource parameter = new MapSqlParameterSource("id", id);
        return jdbcTemplate.queryForObject(sql, parameter, accountRowMapper);
    }

    public List<Account> getAllAccounts() {
        String sql = "SELECT * from ACCOUNT";
        return jdbcTemplate.query(sql, accountRowMapper);
    }

    public int changeAmount(long accountId, BigDecimal amount) {
        String sqlUpdateBalance = "update account set balance = :balance where id = :id";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("balance", amount);
        mapSqlParameterSource.addValue("id", accountId);
        return jdbcTemplate.update(sqlUpdateBalance, mapSqlParameterSource);

    }

}
