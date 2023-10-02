package com.online.shop.service;

import com.online.shop.entity.Category;
import com.online.shop.entity.Product;
import com.online.shop.entity.ProductDTO;
import com.online.shop.exceptions.ProductServiceException;
import com.online.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Validated
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CloudinaryService cloudinaryService;

    /**
     * Create a new product.
     *
     * @param productDTO The product to create.
     * @return The created product.
     * @throws ProductServiceException if the product data is invalid.
     */
    public Product createProduct(@Valid ProductDTO productDTO) {
        try {
            Product existingProduct = productRepository.findByName(productDTO.getName());
            if (existingProduct != null) {
                existingProduct.setStockQuantity(existingProduct.getStockQuantity()+1);
                return productRepository.save(existingProduct);
            } else {
                String imageUrl = cloudinaryService.fetchImageUrlByName(productDTO.getName());
                Category category = new Category(productDTO.getName());
                Product product = new Product(productDTO.getName(), productDTO.getPrice(), productDTO.getDescription()
                        , category, 1, LocalDateTime.now(), LocalDateTime.now(), imageUrl);
                return productRepository.save(product);
            }
        } catch (Exception e) {
            throw new ProductServiceException("Failed to create product: " + e.getMessage(), e);
        }
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long productId) {
        return productRepository.findById(productId);
    }
}

