package com.example.ch8_springboot_webapp.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductsService {
    private List<Product> productList = new ArrayList<>();

    public void addProduct(Product p ){
        productList.add(p);
    }

    public List<Product> findAll(){
        return productList;
    }

}
