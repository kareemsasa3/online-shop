package com.online.shop.controller;

import com.online.shop.entity.Image;
import com.online.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Endpoints...

    @GetMapping("/{productId}/images")
    public List<Image> getProductImages(@PathVariable Long productId) {
        return productService.getProductImages(productId);
    }
}

