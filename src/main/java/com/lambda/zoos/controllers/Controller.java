package com.lambda.zoos.controllers;

import com.lambda.zoos.models.Animal;
import com.lambda.zoos.models.Zoo;
import com.lambda.zoos.services.AnimalService;
import com.lambda.zoos.services.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
public class Controller
{
    @Autowired
    ZooService zooService;

    @Autowired
    AnimalService animalService;

    @GetMapping(value = "/test", produces = "application/json")
    public ResponseEntity<?> doTest()
    {
        ArrayList<Animal> animals = animalService.findAll();
        return new ResponseEntity<>(animals, HttpStatus.OK);
    }

    //GET /zoos/zoos - returns all zoos with their phone numbers and animals
    @GetMapping(value = "/zoos/zoos", produces = "application/json")
    public ResponseEntity<?> getAllZoos()
    {
        ArrayList<Zoo> zoos = zooService.findAll();
        return new ResponseEntity<>(zoos, HttpStatus.OK);
    }

    //GET /zoos/{name} - return the zoo with this name with its phone numbers and animals
    @GetMapping(value = "/zoos/{name}", produces = "application/json")
    public ResponseEntity<?> getZooByName(@PathVariable String name)
    {
        Zoo zoo = zooService.findByName(name);
        return new ResponseEntity<>(zoo, HttpStatus.OK);
    }

    //GET /animals/animals - returns all animals with their zoos
    @GetMapping(value = "/animals/animals", produces = "application/json")
    public ResponseEntity<?> getAllAnimals()
    {
        ArrayList<Animal> animals = animalService.findAll();
        return new ResponseEntity<>(animals, HttpStatus.OK);
    }

    //GET /animals/{name} - return the animal with a list of zoos where they can be found
    @GetMapping(value = "/animals/{name}", produces = "application/json")
    public ResponseEntity<?> getAnimalByName(@PathVariable String name)
    {
        Animal animal = animalService.findByName(name);
        return new ResponseEntity<>(animal, HttpStatus.OK);
    }

    //TODO -- make this actually work
    //GET /animals/count - that returns a JSON object list listing the animals and a count of how many zoos where they can be found. Use a custom query for this.
    @GetMapping(value = "/animals/count", produces = "application/json")
    public ResponseEntity<?> getAnimalCounts()
    {

     return new ResponseEntity<>(animalService.getCountAnimalsInZoo(), HttpStatus.OK);
    }

    //PUT /admin/zoos/{id} - update the zoo referenced by the id number with the provided information
    @PutMapping(value = "/admin/zoos/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updateZoo(@PathVariable long id, @Valid @RequestBody Zoo zoo)
    {
        zooService.update(zoo, id);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    //POST /admin/zoos - add the zoo
    @PostMapping(value = "/admin/zoos", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addZoo(@Valid @RequestBody Zoo zoo)
    {
        Zoo rtn = zooService.save(zoo);
        return new ResponseEntity<>(rtn, HttpStatus.OK);
    }

    //DELETE /admin/zoos/{id} - delete the zoo, associated phone numbers, and zoo animals combination associated with this zoo id
    @PostMapping(value = "/admin/zoos/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> deleteZoo(@PathVariable long id)
    {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
