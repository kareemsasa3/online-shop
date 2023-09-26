package com.online.shop.repository;

import com.online.shop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // You can add custom query methods here if needed
    List<Product> findByCategoryId(Long categoryId);
}
