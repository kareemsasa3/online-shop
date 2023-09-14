package com.online.shop.service;

import com.online.shop.entity.OrderItem;
import com.online.shop.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public OrderItem createOrderItem(OrderItem orderItem) {
        // implement validation or business logic if needed
        return orderItemRepository.save(orderItem);
    }

    public OrderItem getOrderItemById(Long id) {
        return orderItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("OrderItem not found"));
    }

    public OrderItem updateOrderItem(OrderItem orderItem) {
        // implement validation or business logic if needed
        return orderItemRepository.save(orderItem);
    }

    public void deleteOrderItemById(Long id) {
        orderItemRepository.deleteById(id);
    }

    // other methods as needed
}
