package com.online.shop.service;

import com.online.shop.entity.Seller;
import com.online.shop.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class SellerService {
    private final SellerRepository sellerRepository;

    @Autowired
    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public Seller createSeller(Seller seller) {
        // implement validation or business logic if needed
        return sellerRepository.save(seller);
    }

    public Seller getSellerById(Long id) {
        return sellerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Seller not found"));
    }

    public Seller updateSeller(Seller seller) {
        // implement validation or business logic if needed
        return sellerRepository.save(seller);
    }

    public void deleteSellerById(Long id) {
        sellerRepository.deleteById(id);
    }

    // other methods as needed
}
