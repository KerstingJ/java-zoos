package com.lambda.zoos.services;

import com.lambda.zoos.daos.ZooDao;
import com.lambda.zoos.models.Zoo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service(value="zooService")
public class ZooServiceImpl implements ZooService
{
    @Autowired
    ZooDao zooDao;

    @Override
    public ArrayList<Zoo> findAll()
    {
        ArrayList<Zoo> zoos = new ArrayList<>();
        zooDao.findAll().iterator().forEachRemaining(zoos::add);
        return zoos;
    }

    @Override
    public Zoo findByName(String name)
    {
        Zoo zoo = zooDao.findZooByZooname(name);
        return zoo;
    }
}