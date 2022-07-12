package com.example.consolerjdbc.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Animals {

    @Id
    @Generated
    private int animals_id;
    private int persone_id;
    private String kind;
    private String breed;
    private int age;

}
