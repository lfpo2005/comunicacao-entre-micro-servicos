package com.lfcode.productapi.controller;

import com.lfcode.productapi.model.Category;
import com.lfcode.productapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Page<Category>> getAllCategory(@PageableDefault(page = 0, size = 10)
                                                                     Pageable pageable ){

      return ResponseEntity.ok(categoryService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneCategory(@PathVariable(value = "id")Long id){

        Optional<Category> categoryOptional = categoryService.findById(id);
        if(!categoryOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(categoryOptional.get());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCategory(@PathVariable(value = "id")Long id,
                                                 @RequestBody Category category){

        Optional<Category> categoryOptional = categoryService.findById(id);
        if(!categoryOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found");
        }else{
           Category categorySave = categoryService.save(category);
            return ResponseEntity.status(HttpStatus.OK).body(categoryOptional.get());
        }
    }

}
