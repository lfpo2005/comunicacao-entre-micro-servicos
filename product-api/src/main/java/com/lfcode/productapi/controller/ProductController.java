package com.lfcode.productapi.controller;

import com.lfcode.productapi.model.Product;
import com.lfcode.productapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<Page<Product>> getAllProduct(@PageableDefault(page = 0, size = 10)
                                                                 Pageable pageable) {

        return ResponseEntity.ok(productService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable(value = "id") UUID id) {

        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(productOptional.get());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value = "id") UUID id,
                                                 @RequestBody Product product) {

        Optional<Product> productOptional = productService.findById(id);

        if (!productOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found!");
        } else {

            productService.save(product);
            return ResponseEntity.status(HttpStatus.OK).body(productOptional.get());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCategory(@PathVariable(value = "id") UUID id) {

        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found!");
        } else {
            productService.delete(productOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body("Category deleted success!");
        }
    }

    @PostMapping("/")
    public ResponseEntity<Object> registerCategory(@RequestBody Product product) {

        if (productService.existsByNameProduct(product.getNameProduct())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error: Category is Already Taken!");
        } else {

            for (int pos = 0; pos < product.getImages().size(); pos++) {
                product.getImages().get(pos).setProduct(product);
            }

            productService.save(product);
            return ResponseEntity.status(HttpStatus.CREATED).body(product);
        }
    }


}





