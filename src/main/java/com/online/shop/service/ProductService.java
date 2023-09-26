package com.online.shop.service;

import com.online.shop.entity.Category;
import com.online.shop.entity.Product;
import com.online.shop.repository.CategoryRepository;
import com.online.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> getProductsFromCategoryId(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    public Category getCategoryByName(String categoryName) {
        return categoryRepository.findByName(categoryName).orElse(null);
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public void initializeProducts(Map<String, String> productNameToImageUrlMap) {
        for (Map.Entry<String, String> entry : productNameToImageUrlMap.entrySet()) {
            String productName = entry.getKey();
            String imageUrl = entry.getValue();

            Category category = getCategoryByName("Clips");

            Product product = new Product(productName, 29.99, category, 1, LocalDateTime.now());
            product.setImageUrl(imageUrl);

            productRepository.save(product);
        }
    }


}

