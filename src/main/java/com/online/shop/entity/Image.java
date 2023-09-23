package com.online.shop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "image_data", nullable = false)
    private String imageData;

    @Column(name = "image_name")
    private String imageName;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "product_id")
    private Product product;  // Reference to the Product

    // Constructors, getters, and setters

    // Constructors
    public Image() {
    }

    public Image(String imageData, String imageName, Product product) {
        this.imageData = imageData;
        this.imageName = imageName;
        this.product = product;
    }

    public Image(String imageData, String imageName) {
        this.imageData = imageData;
        this.imageName = imageName;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageData() {
        return imageData;
    }

    public void setImageData(String imageData) {
        this.imageData = imageData;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

