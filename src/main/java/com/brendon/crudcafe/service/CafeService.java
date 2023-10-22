package com.brendon.crudcafe.service;

import com.brendon.crudcafe.model.Cafe;
import com.brendon.crudcafe.repository.CafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CafeService {

    private final CafeRepository cafeRepository;

    @Autowired
    public CafeService(CafeRepository cafeRepository) {
        this.cafeRepository = cafeRepository;
    }

    public void createCafe(Cafe cafe) {
        try {
            cafeRepository.save(cafe);
        } catch (Exception e) {
            throw new RuntimeException("Unable to create a cafe. Something went wrong when trying to persist in the db", e);
        }
    }

    public List<Cafe> listCafes() {
        try {
            return cafeRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Unable to list cafes. Something went wrong when trying to retrieve from the db", e);
        }
    }

    public Cafe getCafeById(String cafeId) {
        final Optional<Cafe> cafe;
        try {
            cafe = cafeRepository.findById(Long.valueOf(cafeId));
        } catch (Exception e) {
            throw new RuntimeException("Unable to get cafe " + cafeId + ". Something went wrong when trying to retrieve from the db.", e);
        }
        return cafe.orElseThrow(() -> new RuntimeException("Cafe " + cafeId + "not found"));
    }
}
