package com.lfcode.productapi.service.impl;

import com.lfcode.productapi.model.SubCategoryOne;
import com.lfcode.productapi.repository.SubCategoryOneRepository;
import com.lfcode.productapi.service.SubCategoryOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubCategoryOneServiceImpl implements SubCategoryOneService {


    @Autowired
    SubCategoryOneRepository OneRepository;


    @Override
    public Page<SubCategoryOne> findAll(Pageable pageable){
    return  OneRepository.findAll(pageable);
    }

    @Override
    public Optional<SubCategoryOne> findById(Long id) {

        return OneRepository.findById(id);
    }

    @Override
    public void save(SubCategoryOne subCategoryOne) {
        OneRepository.save(subCategoryOne);
    }

    @Override
    public void delete(SubCategoryOne subCategoryOne) {
        OneRepository.delete(subCategoryOne);
    }


    @Override
    public boolean existsBySubCategoryOne(String subCategoryOne){

        return OneRepository.existsBySubCategoryOne(subCategoryOne);
    }


}
