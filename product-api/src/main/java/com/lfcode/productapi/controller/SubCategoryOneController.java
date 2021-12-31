package com.lfcode.productapi.controller;

import com.lfcode.productapi.model.SubCategoryOne;
import com.lfcode.productapi.service.SubCategoryOneService;
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
@RequestMapping("/api/subcategory/one")
public class SubCategoryOneController {

    @Autowired
    SubCategoryOneService subCategoryOneService;

    @GetMapping
    public ResponseEntity<Page<SubCategoryOne>> getAllCategory(@PageableDefault(page = 0, size = 10)
                                                                 Pageable pageable) {

        return ResponseEntity.ok(subCategoryOneService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneCategory(@PathVariable(value = "id") Long id) {

        Optional<SubCategoryOne> categoryOneOptional = subCategoryOneService.findById(id);
        if (!categoryOneOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(categoryOneOptional.get());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCategory(@PathVariable(value = "id") Long id,
                                                 @RequestBody SubCategoryOne subCategoryOne){

        Optional<SubCategoryOne> categoryOneOptional = subCategoryOneService.findById(id);

        if (!categoryOneOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("SubCategory not found!");
        } else {

            subCategoryOneService.save(subCategoryOne);
            return ResponseEntity.status(HttpStatus.OK).body(categoryOneOptional.get());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCategory(@PathVariable(value = "id") Long id) {

        Optional<SubCategoryOne> categoryOneOptional = subCategoryOneService.findById(id);
        if (!categoryOneOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("SubCategory not found!");
        } else {
            subCategoryOneService.delete(categoryOneOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body("SubCategory deleted success!");
        }
    }

    @PostMapping("/")
    public ResponseEntity<Object> registerCategory(@RequestBody SubCategoryOne subCategoryOne) {

        if (subCategoryOneService.existsBySubCategoryOne(subCategoryOne.getSubCategoryOne())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error: Category is Already Taken!");
        } else {

            subCategoryOneService.save(subCategoryOne);
            return ResponseEntity.status(HttpStatus.CREATED).body(subCategoryOne);
        }
    }
}