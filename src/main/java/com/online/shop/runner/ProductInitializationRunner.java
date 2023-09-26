package com.online.shop.runner;

import com.online.shop.service.CloudinaryService;
import com.online.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ProductInitializationRunner implements CommandLineRunner {

    @Autowired
    private ProductService productService;

    @Autowired
    private CloudinaryService cloudinaryService;

    @Override
    public void run(String... args) throws Exception {
        // initialize products when the application starts
        Map<String, String> imageUrls = cloudinaryService.fetchImageUrls();
        productService.initializeProducts(imageUrls);
    }
}
