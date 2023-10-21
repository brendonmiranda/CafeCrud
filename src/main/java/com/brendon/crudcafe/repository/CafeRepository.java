package com.brendon.crudcafe.repository;

import com.brendon.crudcafe.model.Cafe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CafeRepository extends CrudRepository<Cafe, String> {
}
