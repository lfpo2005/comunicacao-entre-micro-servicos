package com.lfcode.productapi.service;

import com.lfcode.productapi.model.SubCategoryOne;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface SubCategoryOneService {

    Page<SubCategoryOne> findAll(Pageable pageable);

    Optional<SubCategoryOne> findById(Long id);

    void save(SubCategoryOne subCategoryOne);

    void delete(SubCategoryOne subCategoryOne);

      boolean existsBySubCategoryOne(String subCategoryOne);


}
