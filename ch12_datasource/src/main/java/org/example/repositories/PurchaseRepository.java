package org.example.repositories;

import org.example.model.Purchase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PurchaseRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public PurchaseRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void storePurchase(Purchase p){
        String sql = "INSERT into purchase(product, price, id) values(:product,:price, :id)";
        Map<String, Object> params = new HashMap<>();
        params.put("product", p.getProduct());
        params.put("price", p.getPrice());
        params.put("id", p.getId());
        jdbcTemplate.update(sql, params);
    }

    public List<Purchase> findAllPurchases() {
        String sql = "SELECT * from purchase";
        RowMapper<Purchase> purchaseRowMapper = getPurchaseRowMapper();
        return jdbcTemplate.query(sql, purchaseRowMapper);
    }

    private static RowMapper<Purchase> getPurchaseRowMapper() {
        RowMapper<Purchase> purchaseRowMapper = (r,i) -> {
            Purchase rowObject = new Purchase();
            rowObject.setId(r.getInt("id"));
            rowObject.setProduct(r.getString("product"));
            rowObject.setPrice(r.getBigDecimal("price"));
            return rowObject;
        };
        return purchaseRowMapper;
    }

    ;
}
