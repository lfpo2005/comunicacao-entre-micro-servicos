package com.lfcode.productapi.service;

import com.lfcode.productapi.model.Category;
import com.lfcode.productapi.model.Image;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ImageService {


    Page<Image> findAll(Pageable pageable);

    Optional<Image> findById(Long id);

    void save(Image image);

    void delete(Image image);
}
