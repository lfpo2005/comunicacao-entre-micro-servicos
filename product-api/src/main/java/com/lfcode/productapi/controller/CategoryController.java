package com.lfcode.productapi.controller;

import com.lfcode.productapi.model.Category;
import com.lfcode.productapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("v1/api/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategory() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneCategory(@PathVariable(value = "id") Long id) {

        Optional<Category> categoryOptional = categoryService.findById(id);
        if (!categoryOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(categoryOptional.get());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCategory(@PathVariable(value = "id") Long id,
                                                 @RequestBody Category category) {

        Optional<Category> categoryOptional = categoryService.findById(id);

        if (!categoryOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found!");
        } else {
            categoryService.save(category);
            return ResponseEntity.status(HttpStatus.CREATED).body(category);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCategory(@PathVariable(value = "id") Long id) {

        Optional<Category> categoryOptional = categoryService.findById(id);
        if (!categoryOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found!");
        } else {
            categoryService.delete(categoryOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body("Category deleted success!");
        }
    }

    @PostMapping
    public ResponseEntity<Object> saveCategory(@RequestBody Category category) {

      /*  for (int pos = 0 ; pos <category.getSubCategories().size(); pos ++) {
            category.getSubCategories().get(pos).setCategory(category);
        }
        */
            return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.save(category));
    }
}





