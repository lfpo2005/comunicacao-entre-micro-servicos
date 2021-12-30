package com.lfcode.productapi.service.impl;

import com.lfcode.productapi.model.Category;
import com.lfcode.productapi.repository.ProductRepository;
import com.lfcode.productapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    ProductRepository categoryRepository;

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return  categoryRepository.findAll(pageable);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void delete(Category category) {
        categoryRepository.delete(category);
    }

    @Override
    public boolean existsByNameCategory(String nameCategory){
        return categoryRepository.existsByNameCategory(nameCategory);
    }


}
