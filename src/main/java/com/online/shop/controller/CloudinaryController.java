package com.online.shop.controller;

import com.online.shop.service.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class CloudinaryController {

    @Autowired
    private CloudinaryService cloudinaryService;

    @GetMapping("/imageUrls")
    public ResponseEntity<Map<String, String>> getImageUrls() {
        try {
            Map<String, String> imageUrls = cloudinaryService.fetchImageUrls();
            return ResponseEntity.ok(imageUrls);
        } catch (Exception e) {
            // Log the error
            // You can customize the error response based on the exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("error", "Failed to fetch image URLs"));
        }
    }

}

