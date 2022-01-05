package com.lfcode.productapi.service.impl;

import com.lfcode.productapi.model.Supplier;
import com.lfcode.productapi.repository.SupplierRepository;
import com.lfcode.productapi.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    @Override
    public Page<Supplier> findAll(Pageable pageable) {
        return supplierRepository.findAll(pageable);
    }

    @Override
    public Optional<Supplier> findById(Long id) {
        return supplierRepository.findById(id);
    }

    @Override
    public void save(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    @Override
    public void delete(Supplier supplier) {
        supplierRepository.delete(supplier);
    }
}
