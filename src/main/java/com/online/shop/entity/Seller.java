package com.online.shop.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sellers")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

//    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
//    private List<Product> products;

    // Constructors, getters, setters, and other methods

    // Default constructor
    public Seller() {
    }

    // Parameterized constructor
    public Seller(String name) {
        this.name = name;
    }

    // Getter and Setter methods for id, name, and products


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public List<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<Product> products) {
//        this.products = products;
//    }
}

