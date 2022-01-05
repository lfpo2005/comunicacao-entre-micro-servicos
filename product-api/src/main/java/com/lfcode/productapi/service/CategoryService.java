package com.lfcode.productapi.service;

import com.lfcode.productapi.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CategoryService {

    Page<Category> findAll(Pageable pageable);

    Optional<Category> findById(Long id);

    void save(Category category);

    void delete(Category category);

    boolean existsByNameCategory(String nameCategory);


}
