package com.lambda.zoos.services;

import com.lambda.zoos.daos.AnimalDao;
import com.lambda.zoos.models.Animal;
import com.lambda.zoos.views.CountAnimalsInZoo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value="animalService")
public class AnimalServiceImpl implements AnimalService
{
    @Autowired
    AnimalDao animalDao;

    @Override
    public ArrayList<Animal> findAll(){
        ArrayList<Animal> animals = new ArrayList<>();
        animalDao.findAll().iterator().forEachRemaining(a -> animals.add(a));

        return animals;
    }

    @Override
    public Animal findByName(String animalName)
    {
        Animal animal = animalDao.findAnimalByAnimaltype(animalName);
        return animal;
    }

    @Override
    public ArrayList<CountAnimalsInZoo> getCountAnimalsInZoo()
    {
        return animalDao.getCountAnimalsInZoo();
    }
}
