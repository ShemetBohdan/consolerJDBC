package com.example.consolerjdbc.controller;

import com.example.consolerjdbc.model.Persone;
import com.example.consolerjdbc.service.PersoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public Persone getPersone(@PathVariable Integer id) {
        System.out.println(id);
        return personeService.getPersone(id).orElseThrow(()-> new ResponseStatusException(
                HttpStatus.NOT_FOUND,"persone not found"));
    }

    @PostMapping( value = "/{update}")
    public Persone updatePersone(@RequestBody Persone persone){;
        return this.personeService.savePersone(persone);
    }

    @PutMapping( value = "/{add}")
    public Persone savePersone(@RequestBody Persone persone){
        return this.personeService.savePersone(persone);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public void deleteAnimals(@PathVariable Integer id) {
        if (id == 0) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not found");
        }
        System.out.println("removing persone whith id:" + id);
        personeService.removePersone(id);
    }

}
