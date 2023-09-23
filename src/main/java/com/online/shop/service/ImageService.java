package com.online.shop.service;

import com.online.shop.entity.Image;
import com.online.shop.entity.Product;
import com.online.shop.repository.ImageRepository;
import com.online.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Image uploadImage(MultipartFile file, String imageName, Long productId) throws IOException {
        String encodedImageData = convertToBase64(file);

        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isEmpty()) {
            throw new EntityNotFoundException("Product not found with id: " + productId);
        }

        Product product = productOptional.get();
        Image image = new Image(encodedImageData, imageName, product);

        return imageRepository.save(image);
    }

    private static String convertToBase64(MultipartFile file) throws IOException {
        byte[] imageData = file.getBytes();
        return Base64.getEncoder().encodeToString(imageData);
    }

    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    public Optional<Image> getImageById(Long id) {
        return imageRepository.findById(id);
    }

    public List<Image> getImagesFromProductId(Long productId) {
        return imageRepository.findByProductId(productId);
    }

    public void saveImage(Image image) {
        imageRepository.save(image);
    }
}



