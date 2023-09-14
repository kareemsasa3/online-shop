package com.online.shop.service;

import com.online.shop.entity.CartItem;
import com.online.shop.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class CartItemService {
    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartItemService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public CartItem createCartItem(CartItem cartItem) {
        // implement validation or business logic if needed
        return cartItemRepository.save(cartItem);
    }

    public CartItem getCartItemById(Long id) {
        return cartItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("CartItem not found"));
    }

    public CartItem updateCartItem(CartItem cartItem) {
        // implement validation or business logic if needed
        return cartItemRepository.save(cartItem);
    }

    public void deleteCartItemById(Long id) {
        cartItemRepository.deleteById(id);
    }

    // other methods as needed
}
