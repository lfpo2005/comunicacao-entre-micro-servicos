package com.lfcode.productapi.service.impl;

import com.lfcode.productapi.model.Category;
import com.lfcode.productapi.repository.CategoryRepository;
import com.lfcode.productapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;


    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category save(Category category) {

        for (int pos = 0 ; pos <category.getSubCategories().size(); pos ++) {
            category.getSubCategories().get(pos).setCategory(category);
        }

        return categoryRepository.save(category);

    }

    @Override
    public void delete(Category category) {

        categoryRepository.delete(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

}
