package com.example.consolerjdbc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Persone {
    @Id
    private int persone_id;
    private String name;
    private String surname;
    private int age;
    private String gender;
}
