package com.example.ch10_restwebservices.controllers;

import com.example.ch10_restwebservices.exceptions.InsufficientBalanceException;
import com.example.ch10_restwebservices.models.Country;
import com.example.ch10_restwebservices.models.ErrorDetails;
import com.example.ch10_restwebservices.services.BankAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {
    BankAccountService bas;

    public CountryController(BankAccountService bas) {
        this.bas = bas;
    }

    //Note: End point returning regular object
    @GetMapping("/object")
    public List<Country> getCountriesObj() {
        Country c1 = new Country("Philippines", 63);
        Country c2 = new Country("Bahrain", 973);
        return List.of(c1, c2);
    }

    //Note: Using response entity object, we can send specific status, header, and body in response.
    @GetMapping("/entity")
    public ResponseEntity<List<Country>> getCountriesRE() {
        Country c1 = new Country("Philippines", 63);
        Country c2 = new Country("Bahrain", 973);
        return ResponseEntity.status(HttpStatus.OK).header("continent", "Asia")
                .header("capital", "Multi").header("food", "asian food")
                .body(List.of(c1, c2));
    }

    @GetMapping("/exception")
    public ResponseEntity<?> getCountriesEx() {
        try {
            bas.processPayment();
        } catch (InsufficientBalanceException e) {
            ErrorDetails details = new ErrorDetails();
            details.setMessage(e.getMessage());

            //TODO: why is PostMan receiving 406 error instead?
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(details);
        }
        return ResponseEntity.ok().build();
    }
}
