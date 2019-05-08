package com.lambda.zoos.daos;

import com.lambda.zoos.models.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimalDao extends CrudRepository<Animal, Long>
{
    Animal findAnimalByAnimaltype(String type);

}
