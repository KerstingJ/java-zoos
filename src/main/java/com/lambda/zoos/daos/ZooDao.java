package com.lambda.zoos.daos;

import com.lambda.zoos.models.Zoo;
import org.springframework.data.repository.CrudRepository;

public interface ZooDao extends CrudRepository<Zoo, Long>
{
    Zoo findZooByZooname(String zooname);
}
