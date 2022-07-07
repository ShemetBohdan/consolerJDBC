package com.example.consolerjdbc.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class Persone {
    @Id
    private int persone_id;
    private String name;
    private String surname;
    private int age;
    private String gender;
}
