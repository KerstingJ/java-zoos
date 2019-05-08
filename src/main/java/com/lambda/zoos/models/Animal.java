package com.lambda.zoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Animal
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long animalid;
    private String animaltype;

    @ManyToMany(mappedBy = "animals", cascade = CascadeType.DETACH)
    @JsonIgnoreProperties({"animals"})
    private List<Zoo> zoos = new ArrayList<>();

    public Animal()
    {
    }

    public Animal(String animaltype)
    {
        this.animaltype = animaltype;
    }

    public Animal(String animaltype, List<Zoo> zoos)
    {
        this.animaltype = animaltype;
        this.zoos = zoos;
    }

    public Animal(long animalid, String animaltype, List<Zoo> zoos)
    {
        this.animalid = animalid;
        this.animaltype = animaltype;
        this.zoos = zoos;
    }

    public long getAnimalid()
    {
        return animalid;
    }

    public void setAnimalid(long animalid)
    {
        this.animalid = animalid;
    }

    public String getAnimaltype()
    {
        return animaltype;
    }

    public void setAnimaltype(String animaltype)
    {
        this.animaltype = animaltype;
    }

    public List<Zoo> getZoos()
    {
        return zoos;
    }

    public void setZoos(List<Zoo> zoos)
    {
        this.zoos = zoos;
    }

    @Override
    public String toString()
    {
        return "Animal{" + "animalid=" + animalid + ", animaltype='" + animaltype + '\'' + '}';
    }
}
