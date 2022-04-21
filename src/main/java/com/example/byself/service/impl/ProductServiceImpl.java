package com.example.byself.service.impl;

import com.example.byself.models.Image;
import com.example.byself.models.Product;
import com.example.byself.repositories.ProductRepositories;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl {

    private final ProductRepositories productRepositories;

    public List<Product> listProduct(String title) {
        if (title != null) return productRepositories.findByTitle(title);

        return productRepositories.findAll();
    }


    public void saveProduct(Product product, MultipartFile file1, MultipartFile file2, MultipartFile file3)
            throws IOException {
        Image image1;
        Image image2;
        Image image3;

        if (file1.getSize() !=0) {
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            product.addImageProduct(image1);
        }

        if (file1.getSize() !=0) {
            image2 = toImageEntity(file2);
            image2.setPreviewImage(true);
            product.addImageProduct(image2);
        }

        if (file1.getSize() !=0) {
            image3 = toImageEntity(file3);
            image3.setPreviewImage(true);
            product.addImageProduct(image3);
        }

        log.info("Saving new Product. Title: {}; Author: {}", product.getTitle(), product.getAuthor());
        Product productFromOb = productRepositories.save(product);
        productFromOb.setPreviewImageId(productFromOb.getImages().get(0).getId());
        productRepositories.save(product);
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());

        return image;
    }

    public void deleteProduct(Long id) {
        productRepositories.deleteById(id);
    }

    public Product getProductById(Long id) {

        return productRepositories.findById(id).orElse(null);
    }
}

