package com.online.shop.service;

import com.online.shop.entity.Category;
import com.online.shop.entity.Image;
import com.online.shop.entity.Product;
import com.online.shop.exceptions.ProductNotFoundException;
import com.online.shop.repository.CategoryRepository;
import com.online.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        // implement validation or business logic if needed
        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }

    public Product updateProduct(Product product) {
        // implement validation or business logic if needed
        return productRepository.save(product);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    // other methods as needed
    public List<Image> getProductImages(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            return product.getImages();
        } else {
            throw new ProductNotFoundException("Product not found with id: " + productId);
        }
    }

    public void initializeProducts() {
        // Create and save product entities
        String categoryName = "Clips";
        Category category = getCategoryByName(categoryName);

        if (category != null) {
            Product product1 = new Product("Product 1", 29.99, category, 1, LocalDateTime.now());
            productRepository.save(product1);
        } else {
            logger.warn("Category '" + categoryName + "' not found. Creating products with null category.");
            Product productWithNullCategory = new Product("Product 1", 29.99, null, 1, LocalDateTime.now());
            productRepository.save(productWithNullCategory);
        }
    }

    public Category getCategoryByName(String categoryName) {
        return categoryRepository.findByName(categoryName).orElse(null);
    }
}

