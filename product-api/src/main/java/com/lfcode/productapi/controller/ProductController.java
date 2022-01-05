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

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

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
    public ResponseEntity<Object> getOneProduct(@PathVariable(value = "id") Long id) {

        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(productOptional.get());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value = "id") Long id,
                                                 @RequestBody Product product) {

        Optional<Product> productOptional = productService.findById(id);

        if (!productOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found!");
        } else {

            for (int pos = 0; pos < product.getImages().size(); pos++) {
                product.getImages().get(pos).setProduct(product);
            }
            //product.setCreationDate(LocalDateTime.now(ZoneId.of("UTC")));
            product.setLastUpdateDate(LocalDateTime.now(ZoneId.of("UTC")));

            productService.save(product);
            return ResponseEntity.status(HttpStatus.CREATED).body(product);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") Long id) {

        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found!");
        } else {
            productService.delete(productOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body("Product deleted success!");
        }
    }

    @PostMapping("/")
    public ResponseEntity<Object> registerProduct(@RequestBody Product product) {

        if (productService.existsByNameProduct(product.getNameProduct())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error: Product is Already Taken!");
        } else {

            for (int pos = 0; pos < product.getImages().size(); pos++) {
                product.getImages().get(pos).setProduct(product);
            }
            product.setCreationDate(LocalDateTime.now(ZoneId.of("UTC")));
            product.setLastUpdateDate(LocalDateTime.now(ZoneId.of("UTC")));

            productService.save(product);
            return ResponseEntity.status(HttpStatus.CREATED).body(product);
        }
    }


}





