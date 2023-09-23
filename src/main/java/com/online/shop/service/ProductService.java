package com.online.shop.service;

import com.online.shop.entity.Category;
import com.online.shop.entity.Image;
import com.online.shop.entity.Product;
import com.online.shop.repository.CategoryRepository;
import com.online.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ImageService imageService;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> getProductsFromCategoryName(String categoryName) {
        return productRepository.findByCategoryName(categoryName);
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
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

