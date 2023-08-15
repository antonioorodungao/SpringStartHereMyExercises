package com.example.ch8_springboot_webapp;

import com.example.ch8_springboot_webapp.services.Product;
import com.example.ch8_springboot_webapp.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    ProductsService productsService;

    @Override
    public void run(String... args) throws Exception {

        productsService.addProduct(new Product("Milk", 1.0));
        productsService.addProduct(new Product("Cheese", 2.0));
        productsService.addProduct(new Product("Chips", 3.0));
        productsService.addProduct(new Product("Tomato", 4.0));

    }

    public  DataInitializer(ProductsService ps){
       this.productsService=ps;
    }


}
