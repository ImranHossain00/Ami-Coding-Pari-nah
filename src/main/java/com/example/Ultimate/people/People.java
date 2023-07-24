package com.example.Ultimate.people;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class People {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Integer id;
    private String name;
    private Integer age;
    private String email;

    private LocalDate timestamp;

    public People() {
    }

    public People(String name, Integer age, String email, LocalDate timestamp) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.timestamp = timestamp;
    }

    public People(Integer id,
                  String name,
                  Integer age,
                  String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }
}
