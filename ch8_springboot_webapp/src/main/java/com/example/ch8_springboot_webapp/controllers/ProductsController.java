package com.example.ch8_springboot_webapp.controllers;

import com.example.ch8_springboot_webapp.services.Product;
import com.example.ch8_springboot_webapp.services.ProductsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductsController {

    private final ProductsService productsService;

    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public String viewProducts(Model m) {
        List<Product> productList = productsService.findAll();
        m.addAttribute("productlist", productList);
        return "products.html";
    }

    //NOTE: Spring can automatically create a Product object since the parameters are matching the object member property.s
//    @RequestMapping(path="/products",method = RequestMethod.POST)
//    public String addProduct(@RequestParam String name, @RequestParam Double price, Model m){
//        productsService.addProduct(new Product(name, price));
//        List<Product> productList = productsService.findAll();
//        m.addAttribute("productlist", productList);
//        return "products.html";
//    }

    @RequestMapping(path = "/products", method = RequestMethod.POST)
    public String addProduct(Product p, Model m) {
        productsService.addProduct(p);
        List<Product> productList = productsService.findAll();
        m.addAttribute("productlist", productList);
        return "products.html";
    }

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }
}
