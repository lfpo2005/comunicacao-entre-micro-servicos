package com.lfcode.productapi.controller;


import com.lfcode.productapi.model.Image;
import com.lfcode.productapi.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/image")
public class ImageController {

    @Autowired
    ImageService imageService;

    public ResponseEntity<Object> getAllImage(@PageableDefault(page = 0, size = 10)
                                                     Pageable pageable){
        return ResponseEntity.ok(imageService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneCategory(@PathVariable(value = "id") Long id) {

        Optional<Image> categoryOptional = imageService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(categoryOptional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCategory(@PathVariable(value = "id") Long id,
                                                 @RequestBody Image image) {

        Optional<Image> imageOptional = imageService.findById(id);
        if (!imageOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Image not found!");
        } else {
            imageService.save(image);
            return ResponseEntity.status(HttpStatus.OK).body(imageOptional.get());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCategory(@PathVariable(value = "id") Long id) {

        Optional<Image> imageOptional = imageService.findById(id);
        if (!imageOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Image not found!");
        } else {
            imageService.delete(imageOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body("Image deleted success!");
        }
    }

    @PostMapping("/")
    public ResponseEntity<Object> registerCategory(@RequestBody Image image) {

            imageService.save(image);

        return ResponseEntity.status(HttpStatus.CREATED).body(image);
    }

}
