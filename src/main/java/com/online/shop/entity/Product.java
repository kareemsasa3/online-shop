package com.online.shop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, precision = 10, scale = 2)
    private Double price;

    @Column(columnDefinition = "TEXT")
    private String description;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(nullable = false)
    private int stockQuantity;

    @JsonIgnore
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @JsonIgnore
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @JsonIgnore
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Image> images;

//    @ManyToOne
//    @JoinColumn(name = "seller_id")
//    private Seller seller;

    // Constructors

    public Product() {
        // Default constructor
    }

    public Product(String name, Double price, Category category, int stockQuantity, LocalDateTime createdAt) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.stockQuantity = stockQuantity;
        this.createdAt = createdAt;
        this.updatedAt = createdAt;
    }

    // Getters and setters for other attributes

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

//    public Seller getSeller() {
//        return seller;
//    }
//
//    public void setSeller(Seller seller) {
//        this.seller = seller;
//    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    // Additional methods or business logic specific to the Product entity

    // ...
}

