package com.example.Ultimate.people;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PeopleConfig {

    @Bean
    CommandLineRunner commandLineRunner(PeopleRepository peopleRepository) {
        return args -> {

            peopleRepository.saveAll();
        };
    }
}
