package com.lfcode.productapi.repository;

import com.lfcode.productapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface ProductRepository extends JpaRepository <Product, Long>, JpaSpecificationExecutor<Object> {



     boolean existsByNameProduct(String nameProduct);
}
