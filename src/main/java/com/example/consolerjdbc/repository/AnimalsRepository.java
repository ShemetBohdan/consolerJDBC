package com.example.consolerjdbc.repository;

import com.example.consolerjdbc.model.Animals;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalsRepository extends CrudRepository<Animals, Integer> {

    @Query("SELECT * FROM animals LEFT JOIN persone ON animals.persone_id =persone.persone_id WHERE persone.name=:persone")
    public Animals findAnimalsByPersone(@Param("persone")String name);

    public Animals deleteById(int id);

}
