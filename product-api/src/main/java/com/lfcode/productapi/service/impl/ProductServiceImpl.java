package com.lfcode.productapi.service.impl;

import com.lfcode.productapi.model.Product;
import com.lfcode.productapi.repository.ProductRepository;
import com.lfcode.productapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {

        for (int img = 0 ; img <product.getImages().size(); img ++) {
            product.getImages().get(img).setProduct(product);
        }

        return productRepository.save(product);

    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

  }
