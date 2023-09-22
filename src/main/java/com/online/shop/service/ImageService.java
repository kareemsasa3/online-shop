package com.online.shop.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageService {

    @Value("${image.upload.directory}")
    private String uploadDirectory;

    public void saveImage(MultipartFile file) throws IOException {
        Path filePath = Paths.get(uploadDirectory, file.getOriginalFilename());
        Files.write(filePath, file.getBytes());
    }

    public byte[] getImage(String imageName) throws IOException {
        Path imagePath = Paths.get(uploadDirectory, imageName);
        return Files.readAllBytes(imagePath);
    }
}

