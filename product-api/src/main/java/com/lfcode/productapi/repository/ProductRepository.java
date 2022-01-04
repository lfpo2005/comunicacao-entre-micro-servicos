package com.lfcode.productapi.repository;

import com.lfcode.productapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;


public interface ProductRepository extends JpaRepository <Product, UUID>, JpaSpecificationExecutor<Object> {



     boolean existsByNameProduct(String nameProduct);
}
