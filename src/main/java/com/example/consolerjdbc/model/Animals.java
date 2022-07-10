package com.example.consolerjdbc.model;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class Animals {

    @Id
    @Generated
    private int animals_id;
    private int persone_id;
    private String kind;
    private String breed;
    private int age;
}
