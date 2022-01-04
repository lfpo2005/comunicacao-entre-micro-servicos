package com.lfcode.productapi.service.impl;

import com.lfcode.productapi.model.Product;
import com.lfcode.productapi.repository.ProductRepository;
import com.lfcode.productapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Optional<Product> findById(UUID id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);

    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public boolean existsByNameProduct(String nameProduct) {
        return productRepository.existsByNameProduct(nameProduct);
    }
}
