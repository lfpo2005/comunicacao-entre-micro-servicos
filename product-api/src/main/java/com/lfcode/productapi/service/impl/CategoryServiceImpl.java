package com.lfcode.productapi.service.impl;

import com.lfcode.productapi.model.Category;
import com.lfcode.productapi.repository.CategoryRepository;
import com.lfcode.productapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return  categoryRepository.findAll(pageable);
    }
}
