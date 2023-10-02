package com.online.shop.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CategoryDTO {

    @NotBlank(message = "Category name is required")
    private String name;

    public CategoryDTO() {
    }

    public CategoryDTO(String name) {
        this.name = name;
    }
}
