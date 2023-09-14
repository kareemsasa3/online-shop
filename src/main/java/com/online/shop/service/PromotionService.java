package com.online.shop.service;

import com.online.shop.entity.Promotion;
import com.online.shop.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class PromotionService {
    private final PromotionRepository promotionRepository;

    @Autowired
    public PromotionService(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    public Promotion createPromotion(Promotion promotion) {
        // implement validation or business logic if needed
        return promotionRepository.save(promotion);
    }

    public Promotion getPromotionById(Long id) {
        return promotionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Promotion not found"));
    }

    public Promotion updatePromotion(Promotion promotion) {
        // implement validation or business logic if needed
        return promotionRepository.save(promotion);
    }

    public void deletePromotionById(Long id) {
        promotionRepository.deleteById(id);
    }

    // other methods as needed
}
