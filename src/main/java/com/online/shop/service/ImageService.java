package com.online.shop.service;

import com.online.shop.entity.Image;
import com.online.shop.entity.Product;
import com.online.shop.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {

    @Value("${image.upload.directory}")
    private String uploadDirectory; // Set the path to store images

    @Autowired
    private ImageRepository imageRepository;

    public String uploadImage(Product product, MultipartFile file) {
        // Handle image upload and storage
        // Save image details to the database

        // Example: save to a directory
        // String imagePath = saveToDirectory(file);

        // Create the Image entity
        Image image = new Image();
        image.setProduct(product);
        // image.setImagePath(imagePath);

        imageRepository.save(image);

        return image.getImagePath();
    }
}
