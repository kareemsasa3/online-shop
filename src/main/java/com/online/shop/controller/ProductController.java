package com.online.shop.controller;

import com.online.shop.entity.Product;
import com.online.shop.entity.ProductDTO;
import com.online.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Creates a new product.
     *
     * @param productRequest The product details to create.
     * @return ResponseEntity with the created product if successful, or an error response if an exception occurs.
     */
    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody ProductDTO productRequest) {
        try {
            Product createdProduct = productService.createProduct(productRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Retrieves a list of products from the server.
     * This endpoint allows clients to fetch a list of products.
     *
     * @return ResponseEntity with a list of products if successful, or an error response if an exception occurs.
     */
    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        try {
            List<Product> products = productService.getProducts();
            return ResponseEntity.ok().body(products);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.emptyList());
        }
    }

    /**
     * Retrieves a product by its unique identifier.
     *
     * @param productId The unique identifier of the product.
     * @return ResponseEntity with the product if found, or a not found response if the product does not exist.
     */
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
        try {
            Optional<Product> product = productService.getProductById(productId);
            return product.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}


