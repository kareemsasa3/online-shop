package com.online.shop.service;

import com.online.shop.entity.Category;
import com.online.shop.entity.Product;
import com.online.shop.entity.ProductDTO;
import com.online.shop.exceptions.ProductServiceException;
import com.online.shop.repository.CategoryRepository;
import com.online.shop.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
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
    private CategoryRepository categoryRepository;

    @Autowired
    private CloudinaryService cloudinaryService;

    /**
     * Create a new product.
     *
     * @param productDTO The product to create.
     * @return The created product.
     * @throws ProductServiceException if the product data is invalid.
     */
    @Transactional
    public Product createProduct(@Valid ProductDTO productDTO) {
        try {
            String productName = productDTO.getName();
            Product existingProduct = productRepository.findByName(productName);

            if (existingProduct != null) {
                existingProduct.setStockQuantity(existingProduct.getStockQuantity() + 1);
                return productRepository.save(existingProduct);
            } else {
                String imageUrl = cloudinaryService.fetchImageUrlByName(productName);
                System.out.println("Image URL: " + imageUrl);

                Optional<Category> category = categoryRepository.findByName(productDTO.getCategoryName());
                Category productCategory = category.orElse(null);

                Product product = new Product(productName, productDTO.getPrice(), productDTO.getDescription(),
                        productCategory, 1, LocalDateTime.now(), LocalDateTime.now(), imageUrl);
                return productRepository.save(product);
            }
        } catch (EntityNotFoundException ex) {
            throw new ProductServiceException("Category not found: " + productDTO.getCategoryName(), ex);
        } catch (Exception ex) {
            throw new ProductServiceException("Failed to create product: " + ex.getMessage(), ex);
        }
    }


    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long productId) {
        return productRepository.findById(productId);
    }
}

