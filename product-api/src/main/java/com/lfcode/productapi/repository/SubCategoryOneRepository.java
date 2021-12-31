package com.lfcode.productapi.repository;

import com.lfcode.productapi.model.SubCategoryOne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface SubCategoryOneRepository extends JpaRepository <SubCategoryOne, Long>, JpaSpecificationExecutor<Object> {



        boolean existsBySubCategoryOne(String subCategoryOne);

 }
