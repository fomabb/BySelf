package com.example.byself.service.impl;

import com.example.byself.models.Product;
import com.example.byself.repositories.ProductRepositories;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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


    public void saveProduct(Product product) {
        log.info("Saving new {}", product);
        productRepositories.save(product);
    }

    public void deleteProduct(Long id) {
        productRepositories.deleteById(id);
    }

    public Product getProductById(Long id) {

        return productRepositories.findById(id).orElse(null);
    }
}

