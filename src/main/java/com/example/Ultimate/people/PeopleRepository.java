package com.example.Ultimate.people;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeopleRepository
        extends JpaRepository<People, Integer> {
    Optional<People> findPeopleByEmail(String email);
}
