package com.example.consolerjdbc.repository;

import com.example.consolerjdbc.model.Persone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersoneRepository extends CrudRepository<Persone,Integer> {

}
