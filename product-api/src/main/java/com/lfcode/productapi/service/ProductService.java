package com.lfcode.productapi.service;

import com.lfcode.productapi.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    

    Page<Product> findAll(Pageable pageable);

    Optional<Product> findById(UUID id);

    void save(Product product);

    void delete(Product product);

    boolean existsByNameProduct(String nameProduct);

}
