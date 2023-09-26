package com.online.shop.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.online.shop.exceptions.CloudinaryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CloudinaryService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Value("${cloudinary.folder}")
    private String folderName;

    @Autowired
    private Cloudinary cloudinary;

    public Map<String, String> fetchImageUrls() {
        Map<String, String> productNameToImageUrlMap = new HashMap<>();

        try {
            Map<?, ?> result = cloudinary.api().resourcesByTag(folderName, ObjectUtils.emptyMap());
            if (result.containsKey("resources")) {
                List<?> resources = (List<?>) result.get("resources");
                for (Object resource : resources) {
                    if (resource instanceof Map) {
                        Map<?, ?> resourceMap = (Map<?, ?>) resource;
                        String imageName = String.valueOf(resourceMap.get("public_id"));
                        String imageUrl = String.valueOf(resourceMap.get("url"));
                        productNameToImageUrlMap.put(imageName, imageUrl);
                    }
                }
            } else {
                throw new CloudinaryException("Failed to fetch image resources.");
            }
        } catch (CloudinaryException e) {
            handleCloudinaryException(e);
        } catch (Exception e) {
            handleUnexpectedException(e);
        }

        return productNameToImageUrlMap;
    }

    private void handleCloudinaryException(CloudinaryException e) {
        logger.error("CloudinaryException: " + e.getMessage());
        throw e;
    }

    private void handleUnexpectedException(Exception e) {
        logger.error("Exception: " + e.getMessage());
        throw new RuntimeException("An unexpected error occurred.", e);  // Rethrow to propagate the exception
    }


}

