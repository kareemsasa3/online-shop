package com.online.shop.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ProductDTO {

    @NotBlank(message = "Product name is required")
    private String name;

    @NotNull(message = "Price is required")
    private Double price;

    private String description;

    private String categoryName;

    public ProductDTO(String name, Double price, String description, String categoryName) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.categoryName = categoryName;
    }
}
