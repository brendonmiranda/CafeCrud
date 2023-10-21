package com.brendon.crudcafe.service;

import com.brendon.crudcafe.model.Cafe;
import com.brendon.crudcafe.repository.CafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CafeService {

    private final CafeRepository cafeRepository;

    @Autowired
    public CafeService(CafeRepository cafeRepository) {
        this.cafeRepository = cafeRepository;
    }

    public void createCafe(Cafe cafe) {
        cafeRepository.save(cafe);
    }

}
