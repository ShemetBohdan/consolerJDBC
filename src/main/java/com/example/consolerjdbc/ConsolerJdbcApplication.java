package com.example.consolerjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ConsolerJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsolerJdbcApplication.class, args);
    }

}
