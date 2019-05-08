package com.lambda.zoos.controllers;

import com.lambda.zoos.models.Animal;
import com.lambda.zoos.models.Zoo;
import com.lambda.zoos.services.AnimalService;
import com.lambda.zoos.services.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Controller
{
    @Autowired
    ZooService zooService;

    @Autowired
    AnimalService animalService;

    @GetMapping("/test")
    public ResponseEntity<?> doTest()
    {
        ArrayList<Animal> animals = animalService.findAll();
        return new ResponseEntity<>(animals, HttpStatus.OK);
    }

    //GET /zoos/zoos - returns all zoos with their phone numbers and animals
    @GetMapping("/zoos/zoos")
    public ResponseEntity<?> getAllZoos()
    {
        ArrayList<Zoo> zoos = zooService.findAll();
        return new ResponseEntity<>(zoos, HttpStatus.OK);
    }

    //GET /zoos/{name} - return the zoo with this name with its phone numbers and animals
    @GetMapping("/zoos/{name}")
    public ResponseEntity<?> getZooByName(@PathVariable String name)
    {
        Zoo zoo = zooService.findByName(name);
        return new ResponseEntity<>(zoo, HttpStatus.OK);
    }

    //GET /animals/animals - returns all animals with their zoos
    @GetMapping("/animals/animals")
    public ResponseEntity<?> getAllAnimals()
    {
        ArrayList<Animal> animals = animalService.findAll();
        return new ResponseEntity<>(animals, HttpStatus.OK);
    }

    //GET /animals/{name} - return the animal with a list of zoos where they can be found
    @GetMapping("/animals/{name}")
    public ResponseEntity<?> getAnimalByName(@PathVariable String name)
    {
        Animal animal = animalService.findByName(name);
        return new ResponseEntity<>(animal, HttpStatus.OK);
    }

    //GET /animals/count - that returns a JSON object list listing the animals and a count of how many zoos where they can be found. Use a custom query for this.
    @GetMapping("/animals/count")
    public ResponseEntity<?> getAnimalCounts()
    {
     return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
