package com.lambda.zoos.services;

import com.lambda.zoos.models.Zoo;

import java.util.ArrayList;

public interface ZooService
{
    ArrayList<Zoo> findAll();
    Zoo findByName(String name);

}
