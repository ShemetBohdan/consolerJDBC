package com.example.consolerjdbc.controller;

import com.example.consolerjdbc.model.Animals;
import com.example.consolerjdbc.service.AnimalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalsController {

    private AnimalsService animalsService;
    @Autowired
    public AnimalsController(AnimalsService animalService) {
        this.animalsService = animalService;
    }

    @GetMapping( value = "/{id}", produces = "application/json")
    @Cacheable(value = "animalsId")
    public Animals getAnimals(@PathVariable Integer id) {
        System.out.println(id);
        return animalsService.getAnimals(id).orElseThrow(()-> new ResponseStatusException(
                HttpStatus.NOT_FOUND,"animals not found"));
    }

    @GetMapping( "persone/{name}")
    public Animals getAnimalsbyPersone(@PathVariable String name){
        return animalsService.animalsByPersone(name);
    }

    @GetMapping
    public List<Animals> getAllAnimals(){
        return animalsService.getAllAnimals();
    }

    @PostMapping( value = "/{update}")
    public Animals updateAnimals(@RequestBody Animals animals){;
        return this.animalsService.saveAnimals(animals);
    }

    @PutMapping( value = "/{add}")
    public Animals saveAnimals(@RequestBody Animals animals){
        return this.animalsService.saveAnimals(animals);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public void deleteAnimals(@PathVariable Integer id) {
        if (id == 0) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not found");
        }
        System.out.println("removing animals whith id:" + id);
        animalsService.removeAnimals(id);
    }
}
