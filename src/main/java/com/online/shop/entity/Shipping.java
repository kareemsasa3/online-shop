package com.online.shop.entity;

import javax.persistence.*;

@Entity
@Table(name = "shipping_info")
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String postalCode;

    @Column(nullable = false)
    private String country;

    // Constructors, getters, setters, and other methods

    // Default constructor
    public Shipping() {
    }

    // Parameterized constructor
    public Shipping(String address, String city, String postalCode, String country) {
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    // Getter and Setter methods for id, address, city, postalCode, and country

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

