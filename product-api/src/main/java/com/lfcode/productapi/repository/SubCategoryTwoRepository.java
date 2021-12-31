package com.lfcode.productapi.repository;

import com.lfcode.productapi.model.SubCategoryOne;
import com.lfcode.productapi.model.SubCategoryTwo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface SubCategoryTwoRepository extends JpaRepository <SubCategoryTwo, Long>, JpaSpecificationExecutor<Object> {



 boolean existsBySubCategoryTwo(String subCategoryTwo);;
 }
