package com.lfcode.productapi.service;

import com.lfcode.productapi.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    

    Optional<Category> findById(Long id);

    Category save(Category category);

    void delete(Category category);

    List<Category> findAll();
}
