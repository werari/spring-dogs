package com.dog.demo.service;

import java.util.Date;
import java.util.List;

public interface DogService {
    void addDog(String name, Date rescued, Boolean vaccinated);
    void deleteDog (String name, Long id);

    List<String> listDogs (Date rescued);
}
