package org.example.util;

import org.example.model.Purchase;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Random;


@Component
public class RandomPurchase {

    public Purchase getRandomPurchase(){
        Random r = new Random();
        Purchase p = new Purchase();
        p.setProduct(java.util.UUID.randomUUID().toString());
        p.setPrice(new BigDecimal(r.nextDouble(100.00)));
        p.setId(r.nextInt(9999999));
        return p;
    }
}
