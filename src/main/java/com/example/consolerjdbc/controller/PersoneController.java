package com.example.consolerjdbc.controller;

import com.example.consolerjdbc.model.Persone;
import com.example.consolerjdbc.service.PersoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/persone")
public class PersoneController {

    private PersoneService personeService;

    @Autowired
    public PersoneController(PersoneService personeService) {
        this.personeService = personeService;
    }

    @GetMapping( value = "/{id}")
    @Cacheable(value = "personeId")
    public @ResponseBody Persone getPersone(@PathVariable Integer id) {
        System.out.println(id);
        return this.personeService.getPersone(id).orElseThrow(()-> new ResponseStatusException(
                HttpStatus.NOT_FOUND,"persone not found"));
    }

    @PostMapping( value = "/{update}")
    public @ResponseBody Persone updatePersone(@RequestBody Persone persone){;
        return this.personeService.savePersone(persone);
    }

    @PutMapping( value = "/{add}")
    public @ResponseBody Persone savePersone(@RequestBody Persone persone){
        return this.personeService.savePersone(persone);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public Persone deleteAnimals(@PathVariable Integer id) {
        if (id == 0) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not found");
        }
        System.out.println("removing persone whith id:" + id);
        return this.personeService.removePersone(id);
    }

}
