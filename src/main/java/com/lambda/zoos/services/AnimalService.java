package com.lambda.zoos.services;

import com.lambda.zoos.models.Animal;

import java.util.ArrayList;

public interface AnimalService
{
    ArrayList<Animal> findAll();
    Animal findByName(String animalName);
}
