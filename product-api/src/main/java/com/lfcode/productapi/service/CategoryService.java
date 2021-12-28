package com.lfcode.productapi.service;

import com.lfcode.productapi.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {

    Page<Category> findAll(Pageable pageable);
}
