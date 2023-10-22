package com.brendon.crudcafe.repository;

import com.brendon.crudcafe.model.Cafe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CafeRepository extends CrudRepository<Cafe, Long> {

    @Override
    List<Cafe> findAll();

}
