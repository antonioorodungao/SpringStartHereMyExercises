package org.example.controllers;

import org.example.model.Purchase;
import org.example.repositories.PurchaseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    PurchaseRepository purchaseRepository;


    public PurchaseController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @PostMapping
    public void storePurchase(@RequestBody Purchase purchase){
        purchaseRepository.storePurchase(purchase);

    }

    @GetMapping
    public List<Purchase> findPurchases(){
        return purchaseRepository.findAllPurchases();
    }


}
