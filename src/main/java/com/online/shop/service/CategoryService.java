package com.online.shop.service;

import com.online.shop.entity.Category;
import com.online.shop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(Category category) {
        // implement validation or business logic if needed
        return categoryRepository.save(category);
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));
    }

    public Category updateCategory(Category category) {
        // implement validation or business logic if needed
        return categoryRepository.save(category);
    }

    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }

    // other methods as needed
}
