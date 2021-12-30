package com.lfcode.productapi.repository;

import com.lfcode.productapi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface CategoryRepository extends JpaRepository<Category, Long>, JpaSpecificationExecutor<Object> {

     boolean existsByNameCategory(String nameCategory);
}
