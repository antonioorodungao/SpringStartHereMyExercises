package org.example;

import org.example.repositories.PurchaseRepository;
import org.example.util.RandomPurchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;
import java.util.stream.Stream;


@Component
public class Initialize implements CommandLineRunner {

    public Initialize(PurchaseRepository purchaseRepository, RandomPurchase r) {
        this.purchaseRepository = purchaseRepository;
        this.rand = r;

    }

    PurchaseRepository purchaseRepository;
    RandomPurchase rand;

    @Override
    public void run(String... args) throws Exception {

        IntStream.range(1, 10).forEach(x -> purchaseRepository.storePurchase(rand.getRandomPurchase()));

    }

}
