package com.example.consolerjdbc.service;

import com.example.consolerjdbc.model.Persone;
import com.example.consolerjdbc.repository.PersoneRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

public class PersoneServiceTest {

    private PersoneRepository personeRepository = Mockito.mock(PersoneRepository.class);

    private final PersoneRepository spy = Mockito.spy(personeRepository);

    private final PersoneService personeService = new PersoneService(personeRepository);

    @Test
    public void savePersoneTest() {

        Mockito.when(personeRepository.save(Mockito.any()))
                .thenReturn(Persone.builder().name("Luis").build());

        Assertions.assertEquals("Luis", personeService
                .savePersone(Persone.builder().name("Lizi").build()).getName());
    }

    @Test
    public void savePersoneParametrTest() {

        Persone luis = Persone.builder().name("Luis").build();
        Persone luiza = Persone.builder().name("Lizi").build();

        Mockito.when(personeRepository.save(Mockito.any())).thenReturn(luiza);

        Persone persone = personeService.savePersone(luis);

        Assertions.assertNotEquals(persone, luis);
        Assertions.assertEquals(persone, luiza);

        Mockito.verify(personeRepository).save(luis);
    }

    @Test
    public void getPersoneTest() {

        Persone luis = Persone.builder().name("Luis").persone_id(1).build();

        Mockito.when(personeRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(luis));

        Assertions.assertEquals(luis, personeService.getPersone(Mockito.anyInt()).orElse(null));
        Assertions.assertNotEquals(Persone.builder().name("Lizi").build(),
                personeService.getPersone(Mockito.anyInt()).orElse(luis));
    }

    @Test
    public void removePersoneTest() {

        Persone luis = Persone.builder().name("Luis").persone_id(1).build();

        Mockito.when(personeRepository.deleteById(Mockito.anyInt())).thenReturn(luis);

        Assertions.assertEquals(luis, personeService.removePersone(Mockito.anyInt()));
        Assertions.assertNotEquals(Persone.builder().name("Lui").build(),
                personeService.removePersone((Mockito.anyInt())));
    }
}
