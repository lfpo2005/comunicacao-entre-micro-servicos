package com.lfcode.productapi.service;

import com.lfcode.productapi.model.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface SupplierService {
    Page<Supplier> findAll(Pageable pageable);

    Optional<Supplier> findById(Long id);

    void save(Supplier supplier);

    void delete(Supplier supplier);
}
