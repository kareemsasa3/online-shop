package com.online.shop.controller;

import com.online.shop.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            imageService.saveImage(file);
            return ResponseEntity.ok("Image uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Failed to upload image");
        }
    }

    @GetMapping("/{imageName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) {
        try {
            byte[] imageBytes = imageService.getImage(imageName);
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
        } catch (IOException e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}


