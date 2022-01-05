package com.lfcode.productapi.service;

import com.lfcode.productapi.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductService {
    

    Page<Product> findAll(Pageable pageable);

    Optional<Product> findById(Long id);

    void save(Product product);

    void delete(Product product);

    boolean existsByNameProduct(String nameProduct);

}
