package com.example.Ultimate.people;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {

    private PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<People> getPeople() {
        return peopleRepository.findAll();
    }

    public void addNewStudent(People people) {
        Optional<People> people1Optional = peopleRepository.findPeopleByEmail(people.getEmail());

    }

    public boolean searchNumber(String inputValues, int searchValues) {
        List<People> peopleList = peopleRepository.findAll();

        String[] numbersAsStrings = inputValues.split(",");
        int[] numbers = new int[numbersAsStrings.length];

        for (int i = 0; i < numbersAsStrings.length; i++) {
            numbers[i] = Integer.parseInt(numbersAsStrings[i]);
        }


        for (int e : numbers) if (e == searchValues) return true;
        return false;
    }
}
