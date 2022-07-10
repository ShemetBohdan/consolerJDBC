package com.example.consolerjdbc.service;

import com.example.consolerjdbc.model.Persone;
import com.example.consolerjdbc.repository.PersoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PersoneService {

    private final PersoneRepository personeRepository;

    @Autowired
    public PersoneService(PersoneRepository personeRepository) {
        this.personeRepository = personeRepository;
    }

    public Optional<Persone> getPersone(int id){
        return personeRepository.findById(id);
    }

    public Persone savePersone(Persone persone){
        return personeRepository.save(persone);
    }

    public void removePersone(int id){
        personeRepository.deleteById(id);
    }
}
