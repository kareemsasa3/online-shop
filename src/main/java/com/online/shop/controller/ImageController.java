package com.online.shop.controller;

import com.online.shop.entity.Product;
import com.online.shop.service.ImageService;
import com.online.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private ProductService productService;

    @PostMapping("/upload/{productId}")
    public ResponseEntity<String> uploadImage(
            @PathVariable("productId") Long productId,
            @RequestParam("file") MultipartFile file) {

        Product product = productService.getProductById(productId);
        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }

        String imageUrl = imageService.uploadImage(product, file);

        return ResponseEntity.ok().body(imageUrl);
    }
}

