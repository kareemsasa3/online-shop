package com.online.shop.service;

import com.online.shop.entity.Customer;
import com.online.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Customer createUser(Customer customer) {
        // implement validation or business logic if needed
        return userRepository.save(customer);
    }

    public Customer getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    public Customer updateUser(Customer customer) {
        // implement validation or business logic if needed
        return userRepository.save(customer);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    // other methods as needed
}
