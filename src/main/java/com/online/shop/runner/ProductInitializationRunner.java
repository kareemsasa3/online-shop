package com.online.shop.runner;

import com.online.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductInitializationRunner implements CommandLineRunner {

    @Autowired
    private ProductService productService;

    @Override
    public void run(String... args) throws Exception {
        // initialize products when the application starts
        productService.initializeProducts();
    }
}
