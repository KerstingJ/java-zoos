package com.lambda.zoos.daos;

import com.lambda.zoos.models.Animal;
import com.lambda.zoos.views.CountAnimalsInZoo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface AnimalDao extends CrudRepository<Animal, Long>
{
    Animal findAnimalByAnimaltype(String type);

    @Query(value = "select a.animaltype, count(za.animalid) as numzoos from animals a left join zooanimal za on a.animalid = za.animalid group by a.animaltype",
    nativeQuery = true)
    ArrayList<CountAnimalsInZoo> getCountAnimalsInZoo();

}
