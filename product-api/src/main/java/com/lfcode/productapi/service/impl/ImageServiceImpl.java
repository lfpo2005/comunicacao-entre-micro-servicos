package com.lfcode.productapi.service.impl;

import com.lfcode.productapi.model.Image;
import com.lfcode.productapi.repository.CategoryRepository;
import com.lfcode.productapi.repository.ImageRepository;
import com.lfcode.productapi.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageRepository imageRepository;

    @Override
    public Page<Image> findAll(Pageable pageable) {
        return imageRepository.findAll(pageable);
    }

    @Override
    public Optional<Image> findById(Long id) {
        return imageRepository.findById(id);
    }

    @Override
    public void save(Image image) {
        imageRepository.save(image);

    }

    @Override
    public void delete(Image image) {
        imageRepository.delete(image);
    }
}
