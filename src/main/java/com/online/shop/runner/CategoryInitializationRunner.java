package com.online.shop.runner;

import com.online.shop.entity.Category;
import com.online.shop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CategoryInitializationRunner implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) {
        initializeCategories();
    }

    private void initializeCategories() {
        String[] categoryNames = {"Ocean", "Seasonal", "International", "Zoo", "Originals", "Clips", "Reptiles", "Disney"}; // Your category names

        for (String categoryName : categoryNames) {
            Optional<Category> existingCategory = categoryRepository.findByName(categoryName);
            if (existingCategory.isEmpty()) {
                Category category = new Category();
                category.setName(categoryName);
                categoryRepository.save(category);
            }
        }
    }
}
