package com.online.shop.service;

import com.online.shop.entity.Review;
import com.online.shop.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review createReview(Review review) {
        // implement validation or business logic if needed
        return reviewRepository.save(review);
    }

    public Review getReviewById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Review not found"));
    }

    public Review updateReview(Review review) {
        // implement validation or business logic if needed
        return reviewRepository.save(review);
    }

    public void deleteReviewById(Long id) {
        reviewRepository.deleteById(id);
    }

    // other methods as needed
}
