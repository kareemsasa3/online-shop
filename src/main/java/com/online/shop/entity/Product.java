package com.online.shop.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Product name is required")
    @Column(nullable = false)
    private String name;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be a positive value")
    @Column(nullable = false, precision = 10, scale = 2)
    private Double price;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @NotNull(message = "Stock quantity is required")
    @Positive(message = "Stock quantity must be a positive value")
    @Column(nullable = false)
    private int stockQuantity;

    @NotNull(message = "Creation timestamp is required")
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @NotNull(message = "Update timestamp is required")
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @NotBlank(message = "Image URL is required")
    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    public Product() {
        // Default constructor
    }

    public Product(String name, Double price, String description, Category category, int stockQuantity,
                   LocalDateTime createdAt, LocalDateTime updatedAt, String imageUrl) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.stockQuantity = stockQuantity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.imageUrl = imageUrl;
    }
}


