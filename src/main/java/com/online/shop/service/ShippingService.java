package com.online.shop.service;

import com.online.shop.entity.Shipping;
import com.online.shop.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ShippingService {
    private final ShippingRepository shippingRepository;

    @Autowired
    public ShippingService(ShippingRepository shippingRepository) {
        this.shippingRepository = shippingRepository;
    }

    public Shipping createShipping(Shipping shipping) {
        // implement validation or business logic if needed
        return shippingRepository.save(shipping);
    }

    public Shipping getShippingById(Long id) {
        return shippingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Shipping not found"));
    }

    public Shipping updateShipping(Shipping shipping) {
        // implement validation or business logic if needed
        return shippingRepository.save(shipping);
    }

    public void deleteShippingById(Long id) {
        shippingRepository.deleteById(id);
    }

    // other methods as needed
}
