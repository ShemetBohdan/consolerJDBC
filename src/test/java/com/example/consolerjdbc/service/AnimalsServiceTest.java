package com.example.consolerjdbc.service;

import com.example.consolerjdbc.model.Animals;
import com.example.consolerjdbc.repository.AnimalsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

public class AnimalsServiceTest {

    private AnimalsRepository animalsRepository = Mockito.mock(AnimalsRepository.class);

    private final AnimalsRepository spy = Mockito.spy(animalsRepository);

    private final AnimalsService animalsService = new AnimalsService(animalsRepository);

    @Test
    public void saveAnimalsTest() {
        Mockito.when(animalsRepository.save(Mockito.any()))
                .thenReturn(Animals.builder().kind("cat").build());

        Assertions.assertEquals("cat", animalsService
                .saveAnimals(Animals.builder().kind("dog").build()).getKind());
    }

    @Test
    public void saveAnimalsParametrTest() {

        Animals cat = Animals.builder().kind("cat").build();
        Animals dog = Animals.builder().kind("dog").build();

        Mockito.when(animalsRepository.save(Mockito.any())).thenReturn(dog);

        Animals animals = animalsService.saveAnimals(cat);

        Assertions.assertNotEquals(animals, cat);
        Assertions.assertEquals(animals, dog);

        Mockito.verify(animalsRepository).save(cat);
    }

    @Test
    public void getAnimalsTest() {

        Animals cat = Animals.builder().kind("cat").animals_id(1).build();

        Mockito.when(animalsRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(cat));

        Assertions.assertEquals(cat, animalsService.getAnimals(Mockito.anyInt()).orElse(null));
        Assertions.assertNotEquals(Animals.builder().kind("dog").build(),
                animalsService.getAnimals(Mockito.anyInt()).orElse(cat));
    }

    @Test
    public void getAnimalsByPersoneTest() {

        Animals cat = Animals.builder().kind("cat").animals_id(1).build();

        Mockito.when(animalsRepository.findAnimalsByPersone(Mockito.anyString())).thenReturn(cat);

        Assertions.assertEquals(cat, animalsService.animalsByPersone(Mockito.anyString()));
        Assertions.assertNotEquals(Animals.builder().kind("dog").build(),
                animalsService.animalsByPersone(Mockito.anyString()));
    }

    @Test
    public void removeAnimalsTest() {

        Animals cat = Animals.builder().kind("cat").animals_id(1).build();

        Mockito.when(animalsRepository.deleteById(Mockito.anyInt())).thenReturn(cat);

        Assertions.assertEquals(cat, animalsService.removeAnimals(Mockito.anyInt()));
        Assertions.assertNotEquals(Animals.builder().kind("dog").build(),
                animalsService.removeAnimals((Mockito.anyInt())));
    }

}
