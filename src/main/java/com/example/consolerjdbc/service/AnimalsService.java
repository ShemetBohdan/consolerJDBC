package com.example.consolerjdbc.service;

import com.example.consolerjdbc.model.Animals;
import com.example.consolerjdbc.repository.AnimalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnimalsService {

    private final AnimalsRepository animalsRepository;

    @Autowired
    public AnimalsService(AnimalsRepository animalsRepository) {
        this.animalsRepository = animalsRepository;
    }

    public Optional<Animals> getAnimals(int id) {
        return animalsRepository.findById(id);
    }

    public List<Animals> getAllAnimals() {
        List<Animals> animalsList = new ArrayList<>();
        animalsRepository.findAll().forEach(animalsList::add);
        return animalsList;
    }

    public Animals animalsByPersone(String name) {
        return animalsRepository.findAnimalsByPersone(name);
    }

    public Animals saveAnimals(Animals animals) {
        return animalsRepository.save(animals);
    }

    public void removeAnimals(int id) {
        animalsRepository.deleteById(id);
    }

}
