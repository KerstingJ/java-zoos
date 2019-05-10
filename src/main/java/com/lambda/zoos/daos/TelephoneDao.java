package com.lambda.zoos.daos;

import com.lambda.zoos.models.Telephone;
import org.springframework.data.repository.CrudRepository;

public interface TelephoneDao extends CrudRepository<Telephone, Long>
{
}
