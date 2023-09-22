package com.online.shop.repository;

import com.online.shop.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    // You can define custom query methods here if needed.
    Optional<Category> findByName(String name);
}

