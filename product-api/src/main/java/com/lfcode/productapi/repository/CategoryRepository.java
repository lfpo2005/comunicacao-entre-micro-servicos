package com.lfcode.productapi.repository;

import com.lfcode.productapi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;


public interface CategoryRepository extends JpaRepository <Category, UUID>, JpaSpecificationExecutor<Object> {



     boolean existsByNameCategory(String nameCategory);

   //  Optional<Category> findById(UUID id);
}
