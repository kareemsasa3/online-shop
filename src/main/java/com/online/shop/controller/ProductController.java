package com.online.shop.controller;

import com.online.shop.entity.Image;
import com.online.shop.entity.Product;
import com.online.shop.service.ImageService;
import com.online.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ImageService imageService;

    // Other endpoints...

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productService.getProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getProductsFromCategoryId(@PathVariable Long categoryId) {
        List<Product> categoryProducts = productService.getProductsFromCategoryId(categoryId);
        return ResponseEntity.ok(categoryProducts);
    }

    @GetMapping("/{productId}/images")
    public ResponseEntity<List<Image>> getImagesFromProductId(@PathVariable Long productId) {
        List<Image> images = imageService.getImagesFromProductId(productId);
        return ResponseEntity.ok(images);
    }

    @PostMapping("/{productId}/images")
    public ResponseEntity<String> addImageToProduct(@PathVariable Long productId, @RequestBody Image image) {
        // Associate the image with the product
        Product product = productService.getProductById(productId);
        if (product == null) {
            return ResponseEntity.badRequest().body("Product not found with id: " + productId);
        }

        image.setProduct(product);
        imageService.saveImage(image);

        return ResponseEntity.ok("Image added successfully for product with id: " + productId);
    }
}


