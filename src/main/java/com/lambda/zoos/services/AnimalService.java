package com.lambda.zoos.services;

import com.lambda.zoos.models.Animal;
import com.lambda.zoos.views.CountAnimalsInZoo;

import java.util.ArrayList;

public interface AnimalService
{
    ArrayList<Animal> findAll();
    Animal findByName(String animalName);
    ArrayList<CountAnimalsInZoo> getCountAnimalsInZoo();
}
