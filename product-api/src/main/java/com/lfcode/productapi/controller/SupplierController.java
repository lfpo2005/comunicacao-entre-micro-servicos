package com.lfcode.productapi.controller;

import com.lfcode.productapi.model.Supplier;
import com.lfcode.productapi.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @GetMapping
    public ResponseEntity<Page<Supplier>> getAllSupplier(@PageableDefault(page = 0, size = 10)
                                                                 Pageable pageable) {

        return ResponseEntity.ok(supplierService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneSupplier(@PathVariable(value = "id") Long id) {

        Optional<Supplier> supplierOptional = supplierService.findById(id);
        if (!supplierOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Supplier not found");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(supplierOptional.get());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSupplier(@PathVariable(value = "id") Long id,
                                                 @RequestBody Supplier supplier) {

        Optional<Supplier> supplierOptional = supplierService.findById(id);

        if (!supplierOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Supplier not found!");
        } else {

            supplierService.save(supplier);
            return ResponseEntity.status(HttpStatus.OK).body(supplierOptional.get());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSupplier(@PathVariable(value = "id") Long id) {

        Optional<Supplier> supplierOptional = supplierService.findById(id);
        if (!supplierOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found!");
        } else {
            supplierService.delete(supplierOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body("Category deleted success!");
        }
    }

    @PostMapping("/")
    public ResponseEntity<Object> registerSupplier(@RequestBody Supplier supplier) {

            supplierService.save(supplier);
            return ResponseEntity.status(HttpStatus.CREATED).body(supplier);

        }

    }








