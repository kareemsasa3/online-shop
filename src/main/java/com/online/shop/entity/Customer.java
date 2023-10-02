package com.online.shop.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Username is required")
    @Size(max = 255, message = "Username can have at most 255 characters")
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must have at least 6 characters")
    @Column(name = "password", nullable = false)
    private String password;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email address")
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    public Customer() {
    }

    public Customer(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}

