package com.online.shop.service;

import com.online.shop.entity.Order;
import com.online.shop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order) {
        // implement validation or business logic if needed
        return orderRepository.save(order);
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found"));
    }

    public Order updateOrder(Order order) {
        // implement validation or business logic if needed
        return orderRepository.save(order);
    }

    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }

    // other methods as needed
}
