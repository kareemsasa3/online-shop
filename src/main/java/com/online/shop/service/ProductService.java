package com.online.shop.service;

import com.online.shop.entity.Image;
import com.online.shop.entity.Product;
import com.online.shop.exceptions.ProductNotFoundException;
import com.online.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
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
}

