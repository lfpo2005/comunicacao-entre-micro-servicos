package com.lfcode.productapi.repository;

import com.lfcode.productapi.model.Category;
import com.lfcode.productapi.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {


}
